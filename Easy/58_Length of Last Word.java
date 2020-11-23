/* 

58. Length of Last Word

Given a string s consists of some words separated by spaces, return the length of the last word in the string. If the last word does not exist, return 0.

A word is a maximal substring consisting of non-space characters only.


Example 1:

Input: s = "Hello World"
Output: 5


Example 2:

Input: s = " "
Output: 0
 

Constraints:

1 <= s.length <= 10^4
s consists of only English letters and spaces ' '.

*/

/****************************************************

Solution 1

****************************************************/

class Solution {
    public int lengthOfLastWord(String s) {
        int lastLength = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) == ' ' && lastLength > 0) return lastLength;
            else if(s.charAt(i) != ' ') lastLength++;
        }
        return lastLength;
    }
}


/****************************************************

Solution 2 --- JDK functions usage

****************************************************/

class Solution {
    public int lengthOfLastWord(String s) {
        String[] strArr = s.trim().split(" ");
        return strArr.length == 0? 0 : strArr[strArr.length - 1].length();
    }
}


/****************************************************

Solution 3 --- JDK functions usage

****************************************************/


class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        if(s.length() == 0) return 0;
        return s.length() - 1 - s.lastIndexOf(' ');
    }
}
