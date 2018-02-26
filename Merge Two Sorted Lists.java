/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode fakeHead = new ListNode(0);
	    ListNode current = fakeHead;

        while (l1 != null || l2 != null) {
            if (l1 == null || (l2 != null && l1.val >= l2.val)) {
                current.next = l2;
                current = l2;
                l2 = l2.next;
            } else {
                current.next = l1;
                current = l1;
                l1 = l1.next;
            }
        }
        return fakeHead.next;
    }
}


================13ms==========================



public class Solution {
    public ListNode mergeTwoLists(ListNode node1, ListNode node2) {
        ListNode mergedResultPreHead = new ListNode(0);
        ListNode p = mergedResultPreHead;
        
        if (node1 == null && node2 == null) {
            return null;
        }
        
        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                p.next = node1;
                node1 = node1.next;
            } else {
                p.next = node2;
                node2 = node2.next;
            }
            p = p.next;
        }
        
        if (node1 != null) {
            p.next = node1;
        } else {
            p.next = node2;
        }
        
        return mergedResultPreHead.next;
    }	
}



==========recursive=================


class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        
        ListNode mergeHead;
        if(l1.val < l2.val){
            mergeHead = l1;
            mergeHead.next = mergeTwoLists(l1.next, l2);
        }
        else{
            mergeHead = l2;
            mergeHead.next = mergeTwoLists(l1, l2.next);
        }
        return mergeHead;
    }
}