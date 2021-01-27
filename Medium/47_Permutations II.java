/* 

47. Permutations II

Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

Example 1:

Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]

Example 2:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 
Constraints:

1 <= nums.length <= 8
-10 <= nums[i] <= 10

 */

/****************************************************

Solution 1

****************************************************/

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        helper(nums, res, new ArrayList<Integer>(), used);
        
        return res;
    }
    
    private void helper(int[] nums, List<List<Integer>> res, List<Integer> ans, boolean[] used){
        if(ans.size() == nums.length){
            res.add(new ArrayList<Integer>(ans));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) continue;
            ans.add(nums[i]);
            used[i] = true;
            helper(nums, res, ans, used);
            used[i] = false;
            ans.remove(ans.size() - 1);
        }
    }
}