/* 

69. Sqrt(x)

Given a non-negative integer x, compute and return the square root of x.

Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.

Example 1:

Input: x = 4
Output: 2


Example 2:

Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
 

Constraints:

0 <= x <= 2^31 - 1

*/

/****************************************************

Solution 1

****************************************************/

class Solution {
    public int mySqrt(int x) {
        if(x == 0) return 0;
        int start = 1, end = x;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(x / mid == mid || (x / mid > mid && x / (mid + 1) < (mid + 1))) return mid;
            else if(x / mid < mid) end = mid - 1;
            else start = mid + 1;
        }
        return start;
    }
}