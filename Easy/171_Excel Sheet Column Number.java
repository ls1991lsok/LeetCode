/* 

171. Excel Sheet Column Number

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    ...
Example 1:

Input: "A"
Output: 1

Example 2:

Input: "AB"
Output: 28

Example 3:

Input: "ZY"
Output: 701
 

Constraints:

1 <= s.length <= 7
s consists only of uppercase English letters.
s is between "A" and "FXSHRXW".

 */
 

/****************************************************

Solution 1

****************************************************/

class Solution {
    public int titleToNumber(String s) {
        int res = 0;
        for(char c : s.toCharArray()){
            res = res * 26 + (c - 'A' + 1);
        }
        
        return res;
    }
}

/****************************************************

Solution 2 --- Recursive

****************************************************/

class Solution {
    public int titleToNumber(String s) {
        return s.length() == 0? 0 : titleToNumber(s.substring(0, s.length() - 1)) * 26 + (s.charAt(s.length() - 1) - 'A' + 1);
    }
}

