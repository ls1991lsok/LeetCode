/* 

106. Construct Binary Tree from Inorder and Postorder Traversal

Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]

Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length == 0 || inorder.length == 0) return null;
        
        Deque<TreeNode> stk = new ArrayDeque<>();
        int postIndex = postorder.length - 1, inIndex = inorder.length - 1;
        TreeNode root = new TreeNode(postorder[postIndex--]), curRoot = null;
        stk.push(root);
        while(postIndex >= 0){
            while(!stk.isEmpty() && stk.peek().val == inorder[inIndex]){
                curRoot = stk.pop();
                inIndex--;
            }
            TreeNode cur = new TreeNode(postorder[postIndex--]);
            if(curRoot != null) curRoot.left = cur;
            else stk.peek().right = cur;
            stk.push(cur);
            curRoot = null;
        }
        
        return root;
    }
}