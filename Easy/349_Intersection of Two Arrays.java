/* 

349. Intersection of Two Arrays

Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]

Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]

Note:

Each element in the result must be unique.
The result can be in any order.

 */

/****************************************************

Solution 1

****************************************************/

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0) return new int[0];
        
        Set<Integer> set = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for(int num : nums1) set.add(num);
        for(int num : nums2) if(set.contains(num)) res.add(num);
        
        int[] result = new int[res.size()];
        int index = 0;
        for(int ans : res) result[index++] = ans;
        
        return result;
    }
}