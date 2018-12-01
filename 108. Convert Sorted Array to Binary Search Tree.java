/**
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

 /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 //1ms
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null )return null;
        int len = nums.length;
        if(len==0 )return null;
        if(len == 1){ return new TreeNode(nums[0]);}
        if(len == 2){ 
            TreeNode root2 = new TreeNode(nums[0]);
            root2.right = new TreeNode(nums[1]);
            return root2;
        }
        
        int fast =0;
        int slow = 0;
        while (!(fast == len-1 || fast>=len)){
            slow++;
            fast+=2;
        }
        // System.out.print(slow);
        
        TreeNode root = new TreeNode(nums[slow]);
        root.left=sortedArrayToBST(subArray(nums,0 , slow-1));
        root.right=sortedArrayToBST(subArray(nums,slow+1 , len-1));
        return root;
    }
    
    public int[] subArray(int[] nums, int start, int end) {
        int len = end - start+1;
        int[] sub = new int[len];
        for(int i = 0; i<len ;i++){
            sub[i] = nums[start+i];
        }
        return sub;
    }
    
}

//book solution
public TreeNode sortedArrayToBST(int[] num) {
    return sortedArrayToBST(num, 0, num.length-1);
}
private TreeNode sortedArrayToBST(int[] arr, int start, int end) {
    if (start > end) return null;
    int mid = (start + end) / 2;
    TreeNode node = new TreeNode(arr[mid]);
    node.left = sortedArrayToBST(arr, start, mid-1);
    node.right = sortedArrayToBST(arr, mid+1, end);
    return node;
}