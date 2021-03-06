/* 

303. Range Sum Query - Immutable


Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Implement the NumArray class:

NumArray(int[] nums) Initializes the object with the integer array nums.
int sumRange(int i, int j) Return the sum of the elements of the nums array in the range [i, j] inclusive (i.e., sum(nums[i], nums[i + 1], ... , nums[j]))
 

Example 1:

Input
["NumArray", "sumRange", "sumRange", "sumRange"]
[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
Output
[null, 1, -1, -3]

Explanation
NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1)) 
numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
 

Constraints:

0 <= nums.length <= 10^4
-10^5 <= nums[i] <= 10^5
0 <= i <= j < nums.length
At most 10^4 calls will be made to sumRange.

 */

/****************************************************

Solution 1

****************************************************/

class NumArray {
    
    private int[] sumArray;

    public NumArray(int[] nums) {
        if(nums.length != 0){
            sumArray = new int[nums.length];
            sumArray[0] = nums[0];
            for(int i = 1; i < nums.length; i++){
                sumArray[i] = sumArray[i - 1] + nums[i];
            }
        }
    }
    
    public int sumRange(int i, int j) {
        return i == 0? sumArray[j] : sumArray[j] - sumArray[i - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */