/* 

57. Insert Interval

Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]

Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

Example 3:

Input: intervals = [], newInterval = [5,7]
Output: [[5,7]]

Example 4:

Input: intervals = [[1,5]], newInterval = [2,3]
Output: [[1,5]]

Example 5:

Input: intervals = [[1,5]], newInterval = [2,7]
Output: [[1,7]]

Constraints:

0 <= intervals.length <= 10^4
intervals[i].length == 2
0 <= intervals[i][0] <= intervals[i][1] <= 10^5
intervals is sorted by intervals[i][0] in ascending order.
newInterval.length == 2
0 <= newInterval[0] <= newInterval[1] <= 10^5

 */

/****************************************************

Solution 1

****************************************************/

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int[] prev = newInterval, cur;
        for(int i = 0; i < intervals.length; i++){
            cur = intervals[i];
            if(cur[1] < prev[0]) res.add(cur);
            else if(cur[0] > prev[1]){
                res.add(prev);
                prev = cur;
            }else{
                prev[0] = Math.min(cur[0], prev[0]);
                prev[1] = Math.max(cur[1], prev[1]);
            }
        }
        res.add(prev);
        
        return res.toArray(new int[res.size()][2]);
    }
}

/****************************************************

Solution 2

****************************************************/

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int i = 0, start = newInterval[0], end = newInterval[1];
        while(i < intervals.length && intervals[i][1] < start) res.add(intervals[i++]);
        while(i < intervals.length && intervals[i][0] <= end){
            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
        }
        res.add(new int[] {start, end});
        
        while(i < intervals.length) res.add(intervals[i++]);
        
        
        return res.toArray(new int[res.size()][2]);
    }
}