/* 

172. Factorial Trailing Zeroes

Given an integer n, return the number of trailing zeroes in n!.

Follow up: Could you write a solution that works in logarithmic time complexity?

Example 1:

Input: n = 3
Output: 0
Explanation: 3! = 6, no trailing zero.
Example 2:

Input: n = 5
Output: 1
Explanation: 5! = 120, one trailing zero.
Example 3:

Input: n = 0
Output: 0
 

Constraints:

1 <= n <= 10^4

 */
 

/****************************************************

Solution 1

****************************************************/

class Solution {
    public int trailingZeroes(int n) {
        int res = 0;
        while(n != 0){
            res += n / 5;
            n /= 5;
        }
        return res;
    }
}

