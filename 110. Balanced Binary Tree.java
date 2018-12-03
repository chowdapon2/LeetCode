/**
110. Balanced Binary Tree
Easy

Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example 1:

Given the following tree [3,9,20,null,null,15,7]:

    3
   / \
  9  20
    /  \
   15   7
Return true.

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
    
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(isBalanced(root.left) && isBalanced(root.right)){
            int l = depth(root.left);
            int r = depth(root.right);

            if(Math.abs(l-r)<=1){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
        
    }
    
    public int depth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        return Math.max(depth(root.left),depth(root.right))+1;
    }
}



// book solution
public boolean isBalanced(TreeNode root) {
    return maxDepth(root) != -1;
}
private int maxDepth(TreeNode root) {
    if (root == null) return 0;
    int L = maxDepth(root.left);
    if (L == -1) return -1;
    int R = maxDepth(root.right);
    if (R == -1) return -1;
    return (Math.abs(L - R) <= 1) ? (Math.max(L, R) + 1) : -1;
}
