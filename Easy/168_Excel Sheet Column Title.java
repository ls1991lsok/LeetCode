/* 

168. Excel Sheet Column Title

Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
    ...
Example 1:

Input: 1
Output: "A"

Example 2:

Input: 28
Output: "AB"

Example 3:

Input: 701
Output: "ZY"

 */
 

/****************************************************

Solution 1

****************************************************/

class Solution {
    public String convertToTitle(int n) {
        if(n <= 0) return "";
        
        StringBuilder str = new StringBuilder();
        while(n != 0){
            n--;
            str.append((char)('A' + n % 26));
            n /= 26;
        }
        
        return str.reverse().toString();
    }
}

/****************************************************

Solution 2 --- Recursive

****************************************************/

class Solution {
    public String convertToTitle(int n) {
        return n == 0? "" : convertToTitle((n - 1) / 26) + (char)('A' + (n - 1) % 26);
    }
}

