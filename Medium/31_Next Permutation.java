/* 

31. Next Permutation

Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).

The replacement must be in place and use only constant extra memory.

Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]

Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]

Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]

Example 4:

Input: nums = [1]
Output: [1]
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 100

 */

/****************************************************

Solution 1

****************************************************/

class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length < 2) return;
        
        int i = findIndex(nums);
        if(i == -1){
            reverse(nums, 0, nums.length - 1);
            return;
        }
        
        for(int j = nums.length - 1; j > i; j--){
            if(nums[i] < nums[j]){
                swap(nums, i, j);
                break;
            }
        }
        
        reverse(nums, i + 1, nums.length - 1);
    }
    
    private void swap(int[] nums, int start, int end){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
                    
    private void reverse(int[] nums, int start, int end){
        while(start < end) swap(nums, start++, end--);
    }
    
    private int findIndex(int[] nums){
        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] < nums[i + 1]) return i;
        }
        return -1;
    }
}
