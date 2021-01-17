/* 

145. Binary Tree Postorder Traversal

Given the root of a binary tree, return the postorder traversal of its nodes' values.

Example 1:

Input: root = [1,null,2,3]
Output: [3,2,1]

Example 2:

Input: root = []
Output: []

Example 3:

Input: root = [1]
Output: [1]

Example 4:

Input: root = [1,2]
Output: [2,1]

Example 5:

Input: root = [1,null,2]
Output: [2,1]
 
Constraints:

The number of the nodes in the tree is in the range [0, 100].
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stk = new ArrayDeque<>();
        TreeNode node = root;
        while(node != null || !stk.isEmpty()){
            while(node != null){
                stk.push(node);
                if(node.left != null) node = node.left;
                else node = node.right;
            }
            TreeNode cur = stk.pop();
            res.add(cur.val);
            if(!stk.isEmpty() && stk.peek().left == cur) node = stk.peek().right;
        }
        
        return res;
    }
}

/****************************************************

Solution 2

****************************************************/

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(root == null) return res;
        
        Deque<TreeNode> stk = new ArrayDeque<>();
        stk.push(root);
        while(!stk.isEmpty()){
            TreeNode node = stk.pop();
            res.add(0, node.val);
            if(node.left != null) stk.push(node.left);
            if(node.right != null) stk.push(node.right);
        }
        
        return res;
    }
}