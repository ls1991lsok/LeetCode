/* 

16. 3Sum Closest

Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

Constraints:

3 <= nums.length <= 10^3
-10^3 <= nums[i] <= 10^3
-10^4 <= target <= 10^4

 */

/****************************************************

Solution 1

****************************************************/

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int res = nums[0] + nums[1] + nums[nums.length - 1];
        
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            if(i == 0 || nums[i] != nums[i - 1]){
                int sec = i + 1, last = nums.length - 1;
                while(sec < last){
                    int sum = nums[i] + nums[sec] + nums[last];
                    if(sum < target){
                        while(sec < last && nums[sec] == nums[sec + 1]) sec++;
                        sec++;
                    }else if(sum > target){
                        while(sec < last && nums[last] == nums[last - 1]) last--;
                        last--;
                    }else return sum;
                    if(Math.abs(target - sum) < Math.abs(target - res)) res = sum;
                }
            }
        }
        
        return res;
    }
}