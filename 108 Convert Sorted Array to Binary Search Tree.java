/*
108. Convert Sorted Array to Binary Search Tree
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.


Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
*/


class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        int length = nums.length;
        TreeNode root = toBST(nums,0,length-1);
        return root;
    }
    TreeNode toBST(int[] array, int start, int end){
        //忘記判斷有null的情況, 會跳StackOverflowError
        if(start >end) return null;
        
        int mid = (start+end)/2;
        TreeNode root = new TreeNode(array[mid]);
        root.left = toBST(array, start, mid-1);
        root.right = toBST(array, mid+1 ,end);
        return root;
    }
}