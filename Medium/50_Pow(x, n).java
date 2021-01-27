/* 

50. Pow(x, n)

Implement pow(x, n), which calculates x raised to the power n (i.e. xn).

Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000

Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100

Example 3:

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
 
Constraints:

-100.0 < x < 100.0
-2^31 <= n <= 2^31-1
-10^4 <= x^n <= 10^4

 */

/****************************************************

Solution 1

****************************************************/

class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        else if(n == Integer.MIN_VALUE){
            x *= x;
            n /= 2;
        }else if(n < 0){
            x = 1/x;
            n = -n;
        }
        
        return n % 2 == 0? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}