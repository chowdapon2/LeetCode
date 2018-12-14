/**
24. Swap Nodes in Pairs
Medium

Given a linked list, swap every two adjacent nodes and return its head.

Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.
Note:

Your algorithm should use only constant extra space.
You may not modify the values in the list's nodes, only nodes itself may be changed.

 */

 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;;
        ListNode c = head;
        ListNode q1 = head;
        ListNode q2 = head;
        
        while(c != null && c.next !=null){
            q2 = c.next.next;
            q1 = c.next;
            c.next = q2;
            q1.next = c;
            p.next = q1;
            
            p=p.next.next;
            c = q2;
            q1 =q2;
        }
        
        // single node
        if(c != null){
            p.next = c;
        }
        
        return dummy.next;
    }
}