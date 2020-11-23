/* 

104. Maximum Depth of Binary Tree

Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its depth = 3.

/*
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

Solution 1 --- Recursive

****************************************************/

class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        return Math.max(left, right) + 1;
    }
}

/****************************************************

Solution 2 --- Iterative

****************************************************/

class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        
        Deque<TreeNode> nodes = new LinkedList<>();
        Deque<Integer> nums = new LinkedList<>();
        int maxDep = 0;
        nodes.push(root);
        nums.push(1);
        while(!nodes.isEmpty()){
            TreeNode node = nodes.pop();
            int depth = nums.pop();
            maxDep = Math.max(maxDep, depth);
            if(node.right != null){
                nodes.push(node.right);
                nums.push(depth + 1);
            }
            if(node.left != null){
                nodes.push(node.left);
                nums.push(depth + 1);
            }
        }
        
        return maxDep;
    }
}