/* 

112. Path Sum

Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1

return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

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

Solution 1 --- Recursive

****************************************************/

class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if(root.left == null && root.right == null && root.val == sum) return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}

/****************************************************

Solution 2 --- DFS

****************************************************/

class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        
        Deque<TreeNode> nodes = new ArrayDeque<>();
        Deque<Integer> nums = new ArrayDeque<>();
        nodes.push(root);
        nums.push(sum);
        while(!nodes.isEmpty()){
            TreeNode curNode = nodes.pop();
            int curSum = nums.pop();
            if(curNode.left == null && curNode.right == null && curNode.val == curSum) return true;
            if(curNode.right != null){
                nodes.push(curNode.right);
                nums.push(curSum - curNode.val);
            }
            if(curNode.left != null){
                nodes.push(curNode.left);
                nums.push(curSum - curNode.val);
            }
        }
        
        return false;
    }
}

