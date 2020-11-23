/* 

35. Search Insert Position

Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

 

Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2


Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1


Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4


Example 4:

Input: nums = [1,3,5,6], target = 0
Output: 0


Example 5:

Input: nums = [1], target = 0
Output: 0
 

Constraints:

1 <= nums.length <= 10^4
-10^4 <= nums[i] <= 10^4
nums contains distinct values sorted in ascending order.
-10^4 <= target <= 10^4

*/

/****************************************************

Solution 1 --- Binary Search 1

****************************************************/

class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) end = mid - 1;
            else start = mid + 1;
        }
        
        return start;
    }
}

/****************************************************

Solution 2 --- Binary Search 2

****************************************************/


class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        
        while(start < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) end = mid;
            else start = mid + 1;
        }
        
        return nums[start] < target? start + 1 : start;
    }
}

/****************************************************

Solution 3

****************************************************/

class Solution {
    public int searchInsert(int[] nums, int target) {
        if(target < nums[0]) return 0;
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == target) return i;
            else if(nums[i] < target && target < nums[i + 1]) return i + 1;
        }
        
        return target > nums[nums.length - 1]? nums.length : nums.length - 1;
    }
}

