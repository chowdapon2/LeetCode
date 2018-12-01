/**

109. Convert Sorted List to Binary Search Tree


Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted linked list: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5

 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
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

 //18ms
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        if(head.next == null) return new TreeNode(head.val);
        
        // find middle list
        ListNode fast= head;
        ListNode slow = head;
        ListNode pre_end = head;
        
        
        while(!(fast == null || fast.next==null)){
            pre_end = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow.next;
        System.out.print(slow.val);
        
        
        
        TreeNode root = new TreeNode(slow.val);
        pre_end.next = null;
        root.left = sortedListToBST(head);
        root.right= sortedListToBST(temp);
        
        return root;
    }
}


// 1 ms
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        return buildTree(head, null);
    }
    
    public TreeNode buildTree(ListNode head, ListNode tail){
        if (head == tail)
            return null;
        
        ListNode slow = head;
        ListNode fast = head;
        while(fast != tail && fast.next != tail){
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode thead = new TreeNode(slow.val);
        thead.left = buildTree(head, slow);
        thead.right = buildTree(slow.next, tail);
        
        
        return thead;
    }
}


// book
// use a global scope list for two function use
// buttom up
 class Solution {
    private ListNode list;
    
    public TreeNode sortedListToBST(ListNode head) {
        list = head;
        int n = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            n++;
        }
        return sortedListToBST(0, n - 1);
    }
    
    private TreeNode sortedListToBST(int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode leftChild = sortedListToBST(start, mid - 1);
        TreeNode parent = new TreeNode(list.val);
        parent.left = leftChild;
        list = list.next;
        parent.right = sortedListToBST(mid + 1, end);
        return parent;
    }
}