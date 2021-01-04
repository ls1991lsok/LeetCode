/* 

226. Invert Binary Tree

Invert a binary tree.

Example:

Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9

Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1

Trivia:
This problem was inspired by this original tweet by Max Howell:

Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so f*** off.

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
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        
        Deque<TreeNode> stk = new ArrayDeque<>();
        stk.push(root);
        while(!stk.isEmpty()){
            TreeNode cur = stk.pop();
            TreeNode node = cur.left;
            cur.left = cur.right;
            cur.right = node;
            if(cur.right != null) stk.push(cur.right);
            if(cur.left != null) stk. push(cur.left);
        }
        
        return root;
    }
}