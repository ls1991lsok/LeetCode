/* 

18. 4Sum

Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Notice that the solution set must not contain duplicate quadruplets.

Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

Example 2:

Input: nums = [], target = 0
Output: []
 
Constraints:

0 <= nums.length <= 200
-10^9 <= nums[i] <= 10^9
-10^9 <= target <= 10^9

*/

/****************************************************

Solution 1

****************************************************/

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length < 4) return res;
        
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            for(int j = i + 1; j < nums.length - 2; j++){
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;
                int third = j + 1, last = nums.length - 1;
                while(third < last){
                    int sum = nums[i] + nums[j] + nums[third] + nums[last];
                    if(sum == target){
                        res.add(Arrays.asList(nums[i], nums[j], nums[third], nums[last]));
                        while(third < last && nums[third] == nums[third + 1]) third++;
                        while(third < last && nums[last] == nums[last - 1]) last--;
                        third++;
                        last--;
                    }else if(sum < target) third++;
                    else last--;
                }
            }
        }
        
        return res;
    }
}

