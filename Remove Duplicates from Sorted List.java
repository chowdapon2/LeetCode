/*
83. Remove Duplicates from Sorted List
Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.

*/


class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head ==null) return head;
        ListNode p = head;
        ListNode q = head.next;
        
        while(q != null){
            //same value
            if(p.val == q.val){
                p.next=q.next;
                q=q.next;
            }else{
                p = q;
                q = q.next;
            }
        }
        return head;
        
        
        
    }
}