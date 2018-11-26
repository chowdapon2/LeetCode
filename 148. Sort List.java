/**
Merge Sort
Sort a linked list in O(n log n) time using constant space complexity.

Example 1:

 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        
        // find middle node
        ListNode quick = head;
        ListNode slow = head;
        while(quick!=null && quick.next!=null){
            quick = quick.next.next;
            if(quick==null)
                break;
            slow = slow.next;
            
        }
        ListNode rHead = slow.next;
        
        // Critical ~!!!!
        // you need to point left-list end to null
        // or you will got overflow Error
        slow.next = null;
        
        
        ListNode sorted_l = sortList(head);
        ListNode sorted_r = sortList(rHead);
        
        //merge two list
        return merge(sorted_l,sorted_r);
        
    }
    
    public ListNode merge(ListNode lefthead, ListNode rignthead) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode new_node = dummy;
        ListNode l = lefthead;
        ListNode r = rignthead;
        
        // here need to use && not || 
        // use || will get nullpointer issue
        while(l != null && r != null ){
            if(l.val < r.val){
                new_node.next = l;
                l = l.next;
            }else{
                new_node.next = r;
                r = r.next;
            }
            new_node = new_node.next;
        }
        
        // if there is still remain listnode
        if(l!=null){
            new_node.next = l;
        }
        if(r!=null){
            new_node.next = r;
        }
    
        
        return dummy.next;
    }
}