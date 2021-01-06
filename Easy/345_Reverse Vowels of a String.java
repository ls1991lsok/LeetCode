/* 

345. Reverse Vowels of a String

Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:

Input: "hello"
Output: "holle"

Example 2:

Input: "leetcode"
Output: "leotcede"

Note:
The vowels does not include the letter "y".

 */

/****************************************************

Solution 1

****************************************************/

class Solution {
    public String reverseVowels(String s) {
        if(s.length() == 0) return s;
        
        int start = 0, end = s.length() - 1;
        String vowels = "aeiouAEIOU";
        char[] chars = s.toCharArray();
        while(start < end){
            while(start < end && !vowels.contains(chars[start] + "")) start++;
            while(start < end && !vowels.contains(chars[end] + "")) end--;
            
            char c = chars[start];
            chars[start++] = chars[end];
            chars[end--] = c;
        }
        
        return new String(chars);
    }
}