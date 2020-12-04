/* 

125. Valid Palindrome

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true

Example 2:

Input: "race a car"
Output: false
 

Constraints:

s consists only of printable ASCII characters.

*/

/****************************************************

Solution 1

****************************************************/

class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() == 0) return true;
        
        int start = 0, end = s.length() - 1;
        char[] chars = s.toCharArray();
        while(start < end){
            while(start < end && !Character.isLetterOrDigit(chars[start])) start++;
            while(start < end && !Character.isLetterOrDigit(chars[end])) end--;
            
            if(Character.toLowerCase(chars[start]) != Character.toLowerCase(chars[end])) return false;
            start++;
            end--;
        }
        
        return true;
    }
}