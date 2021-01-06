/* 

326. Power of Three

Given an integer n, return true if it is a power of three. Otherwise, return false.

An integer n is a power of three, if there exists an integer x such that n == 3^x.

Example 1:

Input: n = 27
Output: true

Example 2:

Input: n = 0
Output: false

Example 3:

Input: n = 9
Output: true

Example 4:

Input: n = 45
Output: false
 

Constraints:

-2^31 <= n <= 2^31 - 1
 

Follow up: Could you do it without using any loop / recursion?

 */

/****************************************************

Solution 1

****************************************************/

class Solution {
    public boolean isPowerOfThree(int n) {
        if(n <= 0) return false;

        while(n % 3 == 0) n /= 3;
        return n == 1;
    }
}

/****************************************************

Solution 2

****************************************************/

public boolean isPowerOfThree(int n) {
    return (Math.log10(n) / Math.log10(3)) % 1 == 0;
}

/*
If log10(n) / log10(3) returns an int (more precisely, a double but has 0 after decimal point), then n is a power of 3. (original post). 

But be careful here, you cannot use log (natural log) here, because it will generate round off error for n=243. This is more like a coincidence. I mean when n=243, we have the following results:

log(243) = 5.493061443340548    log(3) = 1.0986122886681098
   ==> log(243)/log(3) = 4.999999999999999

log10(243) = 2.385606273598312    log10(3) = 0.47712125471966244
   ==> log10(243)/log10(3) = 5.0

This happens because log(3) is actually slightly larger than its true value due to round off, which makes the ratio smaller.

Link: https://leetcode.com/problems/power-of-three/discuss/77876/**-A-summary-of-all-solutions-(new-method-included-at-15:30pm-Jan-8th)
*/

/****************************************************

Solution 3

****************************************************/

class Solution {
    public boolean isPowerOfThree(int n) {
        return n > 0 && (1162261467 % n == 0);
    }
}

// 1162261467 is 3^19,  3^20 is bigger than int 
// Link: https://leetcode.com/problems/power-of-three/discuss/77856/1-line-java-solution-without-loop-recursion