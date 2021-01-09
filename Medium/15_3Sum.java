/* 

15. 3Sum

Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Notice that the solution set must not contain duplicate triplets.

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]

Example 2:

Input: nums = []
Output: []

Example 3:

Input: nums = [0]
Output: []
 

Constraints:

0 <= nums.length <= 3000
-10^5 <= nums[i] <= 10^5

 */

/****************************************************

Solution 1

****************************************************/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if(nums.length < 3) return res;
        
        Arrays.sort(nums);
        for(int i = 0; i < nums.length -2; i++){
            if(nums[i] > 0) break;
            if(i == 0 || nums[i] != nums[i - 1]){
                int sec = i + 1, last = nums.length - 1, sum = 0 - nums[i];
                while(sec < last){
                    if(nums[sec] + nums[last] == sum){
                        res.add(Arrays.asList(nums[i], nums[sec], nums[last]));
                        while(sec < last && nums[sec] == nums[sec + 1]) sec++;
                        while(sec < last && nums[last] == nums[last - 1]) last--;
                        sec++;
                        last--;
                    }else if(nums[sec] + nums[last] < sum) sec++;
                    else last--;
                }
            }
        }
        
        return res;
    }
}