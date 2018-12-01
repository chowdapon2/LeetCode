/**
111. Minimum Depth of Binary Tree
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its minimum depth = 2.


 */

 /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
     public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int l = minDepth(root.left);
        int r = minDepth(root.right);
         if(r == 0 || l == 0){
             return r + l + 1;
         }else{
             return Math.min(l,r) + 1;
         }
    }
  
}

/*
Solution:
O(n) runtime, O(log n) space – Depth-first traversal:
Similar to the [Recursion] approach to find the maximum depth, but make sure you
consider these cases:
i. The node itself is a leaf node. The minimum depth is one.
ii. Node that has one empty sub-tree while the other one is non-empty. Return
the minimum depth of that non-empty sub-tree.

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return minDepth(root.right) + 1;
        if (root.right == null) return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
*/



