/* 

5. Longest Palindromic Substring

Given a string s, return the longest palindromic substring in s.

Example 1:

Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Example 2:

Input: s = "cbbd"
Output: "bb"

Example 3:

Input: s = "a"
Output: "a"

Example 4:

Input: s = "ac"
Output: "a"
 

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters (lower-case and/or upper-case),

 */

/****************************************************

Solution 1

****************************************************/

class Solution {
    public String longestPalindrome(String s) {
        int subLeft = 0;
        int subRight = 0;
        for(int i = 0; i < s.length(); i++){
            int left = i, right = i;
            while(left >= 0 && s.charAt(left) == s.charAt(i)) left--;
            while(right < s.length() && s.charAt(right) == s.charAt(i)) right++;
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }
            
            left++;
            if(right - left > subRight - subLeft){
                subLeft = left;
                subRight = right;
            }
        }
        
        return s.substring(subLeft, subRight);
    }
}