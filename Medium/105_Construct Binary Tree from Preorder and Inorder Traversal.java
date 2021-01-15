/* 

105. Construct Binary Tree from Preorder and Inorder Traversal

Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0) return null;
        
        Deque<TreeNode> stk = new ArrayDeque<>();
        int preIndex = 0, inIndex = 0;
        TreeNode root = new TreeNode(preorder[preIndex++]), curRoot = null;
        stk.push(root);
        while(preIndex < preorder.length){
            while(!stk.isEmpty() && stk.peek().val == inorder[inIndex]){
                curRoot = stk.pop();
                inIndex++;
            }
            TreeNode cur = new TreeNode(preorder[preIndex++]);
            if(curRoot != null) curRoot.right = cur;
            else stk.peek().left = cur;
            stk.push(cur);
            curRoot = null;
        }
        
        return root;
    }
}