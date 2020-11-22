/* 

13. Roman to Integer

Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.

 

Example 1:

Input: s = "III"
Output: 3


Example 2:

Input: s = "IV"
Output: 4


Example 3:

Input: s = "IX"
Output: 9


Example 4:

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.


Example 5:

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 

Constraints:

1 <= s.length <= 15
s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
It is guaranteed that s is a valid roman numeral in the range [1, 3999].

*/

/**************************************************************************

Solution 1

**************************************************************************/


class Solution {
    public int romanToInt(String s) {
        int res = 0;
        
        for(int i = 0; i < s.length() - 1; i++){
            if(toInt(s.charAt(i + 1)) > toInt(s.charAt(i))) res -= toInt(s.charAt(i));
            else res += toInt(s.charAt(i));
        }
        
        return res + toInt(s.charAt(s.length() - 1));
    }
    
    public static int toInt(char c){
        if(c == 'I') return 1;
        if(c == 'V') return 5;
        if(c == 'X') return 10;
        if(c == 'L') return 50;
        if(c == 'C') return 100;
        if(c == 'D') return 500;
        if(c == 'M') return 1000;
        
        return 0;
    }
}


/**************************************************************************

Solution 2

**************************************************************************/


class Solution {
    public int romanToInt(String s) {
        int res = 0;
        
        for(int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) == 'I') res += (res >= 5? -1 : 1);
            else if(s.charAt(i) == 'V') res += 5;
            else if(s.charAt(i) == 'X') res += (res >= 50? -10 : 10);
            else if(s.charAt(i) == 'L') res += 50;
            else if(s.charAt(i) == 'C') res += (res >= 500? -100 : 100);
            else if(s.charAt(i) == 'D') res += 500;
            else if(s.charAt(i) == 'M') res += 1000;
        }
        
        return res;
    }
}



