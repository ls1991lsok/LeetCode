/* 

20. Valid Parentheses

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
 

Example 1:

Input: s = "()"
Output: true


Example 2:

Input: s = "()[]{}"
Output: true


Example 3:

Input: s = "(]"
Output: false


Example 4:

Input: s = "([)]"
Output: false


Example 5:

Input: s = "{[]}"
Output: true
 

Constraints:

1 <= s.length <= 10^4
s consists of parentheses only '()[]{}'.

*/

class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0) return false;
        
        Deque<Character> stk = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            if(c == '(') stk.push(')');
            else if(c == '[') stk.push(']');
            else if(c == '{') stk.push('}');
            else if(stk.isEmpty() || stk.pop() != c) return false;
        }
        
        return stk.isEmpty();
    }
}


