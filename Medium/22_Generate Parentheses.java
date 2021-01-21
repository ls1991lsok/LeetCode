/* 

22. Generate Parentheses

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

Example 2:

Input: n = 1
Output: ["()"]
 
Constraints:

1 <= n <= 8

*/

/****************************************************

Solution 1

****************************************************/

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res, new StringBuilder(), 0, 0, n);
        return res;
    }
    
    private void helper(List<String> res, StringBuilder sb, int open, int close, int n){
        if(open == n && close == n){
            res.add(sb.toString());
            return;
        }
        
        if(open < n){
            helper(res, sb.append("("), open + 1, close, n);
            sb.setLength(sb.length() - 1);
        }
        if(close < open){
            helper(res, sb.append(")"), open, close + 1, n);
            sb.setLength(sb.length() - 1);
        }
    }
}

