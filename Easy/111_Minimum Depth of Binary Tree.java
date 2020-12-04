/* 

111. Minimum Depth of Binary Tree

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: 2


Example 2:

Input: root = [2,null,3,null,4,null,5,null,6]
Output: 5
 

Constraints:

The number of nodes in the tree is in the range [0, 10^5].
-1000 <= Node.val <= 1000

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

Solution 1 --- BFS

****************************************************/


class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        
        Deque<TreeNode> queue = new ArrayDeque<>();
        int depth = 0;
        queue.offer(root);
        while(!queue.isEmpty()){
            depth++;
            int curSize = queue.size();
            for(int i = 0; i < curSize; i++){
                TreeNode cur = queue.poll();
                if(cur.left == null && cur.right == null) return depth; 
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
            }
        }
        
        return depth;
    }
}

/****************************************************

Solution 2 --- Recursive

****************************************************/

class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        
        return 1 + (Math.min(left, right) > 0? Math.min(left, right) : Math.max(left, right));
    }
}

