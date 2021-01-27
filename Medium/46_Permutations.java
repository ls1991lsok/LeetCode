/* 

46. Permutations

Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]

Example 3:

Input: nums = [1]
Output: [[1]]
 
Constraints:

1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.

 */

/****************************************************

Solution 1

****************************************************/

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        
        boolean[] used = new boolean[nums.length];
        helper(nums, res, new ArrayList<Integer>(), used);
        
        return res;
    }
    
    private void helper(int[] nums, List<List<Integer>> res, List<Integer> ans, boolean[] used){
        if(ans.size() == nums.length){
            res.add(new ArrayList<Integer>(ans));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(used[i]) continue;
            ans.add(nums[i]);
            used[i] = true;
            helper(nums, res, ans, used);
            used[i] = false;
            ans.remove(ans.size() - 1);
        }
    }
}

/****************************************************

Solution 2 --- Extended from 31. Next Permutation

****************************************************/

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0) return res;
        
        Arrays.sort(nums);
        res.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        int i = findIndex(nums);
        while(i != -1){
            for(int j = nums.length - 1; j > i; j--){
                if(nums[j] > nums[i]){
                    swap(nums, i, j);
                    break;
                }
            }
            reverse(nums, i + 1, nums.length - 1);
            res.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            i = findIndex(nums);
        }
        
        return res;
        
    }
    
    private int findIndex(int[] nums){
        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] < nums[i + 1]) return i;
        }
        return -1;
    }
    
    private void swap(int[] nums, int start, int end){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
    
    private void reverse(int[] nums, int start, int end){
        while(start < end) swap(nums, start++, end--);
    }
}