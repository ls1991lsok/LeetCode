/* 

49. Group Anagrams

Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Example 2:

Input: strs = [""]
Output: [[""]]

Example 3:

Input: strs = ["a"]
Output: [["a"]]
 
Constraints:

1 <= strs.length <= 10^4
0 <= strs[i].length <= 100
strs[i] consists of lower-case English letters.

 */

/****************************************************

Solution 1

****************************************************/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) return new ArrayList<>();
        
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            char[] chars = new char[26];
            for(char c : strs[i].toCharArray()) chars[c - 'a']++;
            String key = String.valueOf(chars);
            if(!map.containsKey(key)) map.put(key, new ArrayList<>(Arrays.asList(strs[i])));
            else map.get(key).add(strs[i]);
        }
        
        return new ArrayList<>(map.values());
    }
}