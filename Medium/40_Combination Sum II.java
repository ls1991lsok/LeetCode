/* 

40. Combination Sum II

Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]

Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]
 
Constraints:

1 <= candidates.length <= 100
1 <= candidates[i] <= 50
1 <= target <= 30

 */

/****************************************************

Solution 1

****************************************************/

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        helper(res, new ArrayList<Integer>(), candidates, target, 0);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> ans, int[] candidates, int target, int start){
        if(target > 0){
            for(int i = start; i < candidates.length && candidates[i] <= target; i++){
                if(i > start && candidates[i] == candidates[i - 1]) continue;
                ans.add(candidates[i]);
                helper(res, ans, candidates, target - candidates[i], i + 1);
                ans.remove(ans.size() - 1);
            }
        }else if(target == 0) res.add(new ArrayList<Integer>(ans));
    }
}