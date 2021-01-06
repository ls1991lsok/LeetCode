/* 

367. Valid Perfect Square

Given a positive integer num, write a function which returns True if num is a perfect square else False.

Follow up: Do not use any built-in library function such as sqrt.

Example 1:

Input: num = 16
Output: true

Example 2:

Input: num = 14
Output: false
 
Constraints:

1 <= num <= 2^31 - 1

 */

/****************************************************

Solution 1

****************************************************/

class Solution {
    public boolean isPerfectSquare(int num) {
        int start = 1, end = num;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(num / mid == mid && num % mid == 0) return true;
            else if(num / mid < mid) end = mid - 1;
            else start = mid + 1;
        }
        
        return false;
    }
}

/****************************************************

Solution 2

****************************************************/

class Solution {
    public boolean isPerfectSquare(int num) {
        int i = 1;
        while(num > 0){
            num -= i;
            i += 2;
        }
        
        return num == 0;
    }
}


/*

This is a math problem：
1 = 1
4 = 1 + 3
9 = 1 + 3 + 5
16 = 1 + 3 + 5 + 7
25 = 1 + 3 + 5 + 7 + 9
36 = 1 + 3 + 5 + 7 + 9 + 11
....
so 1+3+...+(2n-1) = (2n-1 + 1)n/2 = n*n

Link: https://leetcode.com/problems/valid-perfect-square/discuss/83874/A-square-number-is-1+3+5+7+...-JAVA-code/88308

*/