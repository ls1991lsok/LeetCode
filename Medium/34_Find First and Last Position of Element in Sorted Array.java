/* 

34. Find First and Last Position of Element in Sorted Array

Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

Follow up: Could you write an algorithm with O(log n) runtime complexity?

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 
Constraints:

0 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
nums is a non-decreasing array.
-10^9 <= target <= 10^9

 */

/****************************************************

Solution 1

****************************************************/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = findStart(nums, target);
        res[1] = findEnd(nums, target);
        return res;
    }
    
    private int findStart(int[] nums, int target){
        int index = -1, start = 0, end = nums.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] >= target) end = mid - 1;
            else start = mid + 1;
            if(nums[mid] == target) index = mid;
        }
        return index;
    }
    
    private int findEnd(int[] nums, int target){
        int index = -1, start = 0, end = nums.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] <= target) start = mid + 1;
            else end = mid - 1;
            if(nums[mid] == target) index = mid;
        }
        return index;
    }
}