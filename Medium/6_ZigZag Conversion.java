/* 

6. ZigZag Conversion

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
 

Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"

Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"

Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I

Example 3:

Input: s = "A", numRows = 1
Output: "A"
 

Constraints:

1 <= s.length <= 1000
s consists of English letters (lower-case and upper-case), ',' and '.'.
1 <= numRows <= 1000

 */

/****************************************************

Solution 1

****************************************************/

class Solution {
    public String convert(String s, int numRows) {
        StringBuilder[] strs = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++) strs[i] = new StringBuilder();
        
        int i = 0;
        while(i < s.length()){
            for(int row = 0; row < numRows && i < s.length(); row++) strs[row].append(s.charAt(i++));
            for(int row = numRows - 2; row > 0 && i < s.length(); row--) strs[row].append(s.charAt(i++));
        }
        
        for(int j = 1; j < numRows; j++) strs[0].append(strs[j]);
        
        return strs[0].toString();
    }
}

/****************************************************

Solution 2

****************************************************/

class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        
        StringBuilder str = new StringBuilder();
        int cycle_num = 2 * numRows - 2;       
        for(int row = 0; row < numRows; row++){
            for(int i = 0; i + row < s.length(); i += cycle_num){
                str.append(s.charAt(i + row));
                if(row != 0 && row != numRows - 1 && i + cycle_num - row < s.length()) str.append(s.charAt(i + cycle_num - row));
            }
        }
        
        return str.toString();
    }
}