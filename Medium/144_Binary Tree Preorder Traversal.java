/* 

144. Binary Tree Preorder Traversal

Given the root of a binary tree, return the preorder traversal of its nodes' values.

Example 1:

Input: root = [1,null,2,3]
Output: [1,2,3]

Example 2:

Input: root = []
Output: []

Example 3:

Input: root = [1]
Output: [1]

Example 4:

Input: root = [1,2]
Output: [1,2]

Example 5:

Input: root = [1,null,2]
Output: [1,2]
 

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 
Follow up:

Recursive solution is trivial, could you do it iteratively?

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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stk = new ArrayDeque<>();
        TreeNode node = root;
        
        while(node != null || !stk.isEmpty()){
            while(node != null){
                stk.push(node);
                res.add(node.val);
                node = node.left;
            }
            node = stk.pop();
            node = node.right;
        }
        
        return res;
    }
}

/****************************************************

Solution 2

****************************************************/

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        
        Deque<TreeNode> stk = new ArrayDeque<>();
        stk.push(root);
        while(!stk.isEmpty()){
            TreeNode node = stk.pop();
            res.add(node.val);
            if(node.right != null) stk.push(node.right);
            if(node.left != null) stk.push(node.left);
        }
        
        return res;
    }
}