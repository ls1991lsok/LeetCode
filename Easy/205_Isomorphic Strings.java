/* 

205. Isomorphic Strings

Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
Note:
You may assume both s and t have the same length.

 */

/****************************************************

Solution 1

****************************************************/

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() == 0 || t.length() == 0) return s.equals(t);
        
        int len = s.length();
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < len; i++){
            if(!map.containsKey(s.charAt(i))){
                if(!set.add(t.charAt(i))) return false;
                map.put(s.charAt(i), t.charAt(i));
            }else{
                if(map.get(s.charAt(i)) != t.charAt(i)) return false;
            }
        }
        
        return true;
    }
}