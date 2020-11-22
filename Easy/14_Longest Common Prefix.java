/* 

14. Longest Common Prefix

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"


Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 

Constraints:

0 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lower-case English letters.

*/

/****************************************************

Solution 1

****************************************************/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        
        String LCP = strs[0];
        for(int i = 1; i < strs.length; i++){
            while(!strs[i].startsWith(LCP)) LCP = LCP.substring(0, LCP.length() - 1);
            if(LCP.equals("")) break;
        }
        
        return LCP;
    }
}


/****************************************************

Solution 2

****************************************************/


class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        
        String LCP = strs[0];
        for(int i = 1; i < strs.length; i++){
            StringBuilder str = new StringBuilder();
            int pos = 0;
            while(!LCP.equals("") && pos < strs[i].length() && pos < LCP.length()){
                if(LCP.charAt(pos) != strs[i].charAt(pos)) break;
                str.append(LCP.charAt(pos));
                pos++;
            }
            LCP = str.toString();
            if(LCP.equals("")) break;
        }
        
        return LCP;
    }
}


