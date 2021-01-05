/* 

257. Binary Tree Paths

Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:

Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/****************************************************

Solution 1

****************************************************/

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null) return res;
        StringBuilder str = new StringBuilder();
        helper(root, res, str);
        return res;
        
    }
    
    public void helper(TreeNode root, List<String> res, StringBuilder str){
        if(root == null) return;
        int len = str.length();
        if(root.left == null && root.right == null) res.add(str.append(root.val).toString());
        else{
            str.append(root.val);
            str.append("->");
            helper(root.left, res, str);
            helper(root.right, res, str);
        }
        str.setLength(len);
    }
}

/****************************************************

Solution 2

****************************************************/

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null) return res;
        
        Deque<TreeNode> nodes = new ArrayDeque<>();
        Deque<String> strs = new ArrayDeque<>();
        nodes.push(root);
        strs.push("");
        while(!nodes.isEmpty()){
            TreeNode node = nodes.pop();
            String str = strs.pop();
            if(node.left == null && node.right == null) res.add(str + node.val);
            if(node.right != null){
                nodes.push(node.right);
                strs.push(str + node.val + "->");
            }
            if(node.left != null){
                nodes.push(node.left);
                strs.push(str + node.val + "->");
            }
        }
        
        return res;
    }
}