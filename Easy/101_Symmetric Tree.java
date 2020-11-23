/* 

101. Symmetric Tree

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
 

But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3
 

Follow up: Solve it both recursively and iteratively.

*/

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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return check(root.left, root.right);
    }
    
    private boolean check(TreeNode left, TreeNode right){
        if(left == null || right == null) return left == right;
        return left.val == right.val && check(left.left, right.right) && check(left.right, right.left);
    }
}

/****************************************************

Solution 2 --- Iterative

****************************************************/

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        
        Deque<TreeNode> stk = new LinkedList<>();
        stk.push(root.right);
        stk.push(root.left);
        while(!stk.isEmpty()){
            TreeNode left = stk.pop();
            TreeNode right = stk.pop();
            if(left == null && right == null) continue;
            if(left == null || right == null || left.val != right.val) return false;
            stk.push(right.left);
            stk.push(left.right);
            stk.push(right.right);
            stk.push(left.left);
        }
        
        return true;
    }
}