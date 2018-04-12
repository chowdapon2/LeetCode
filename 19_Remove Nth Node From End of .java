/*
19. Remove Nth Node From End of 
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
*/

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = n;
        ListNode end =head;
        ListNode start = head;
        ListNode start_pre = null;
        while(count>1){
            end = end.next;
            // System.out.print(end.val);
            count--;
        }
        //move two pointer ralatively
        while(end.next!=null){
            start_pre =start;
            start = start.next;
            end = end.next;
            // System.out.println("second: "+end.val);
        }
        
        //if delete in the head node
        if(start_pre == null ) {
            return head.next;
        }
        
            
        
        //delete node
        start_pre.next = start.next;
        
        
        return head;
    }
}

//別人的好解法
public ListNode removeNthFromEnd(ListNode head, int n) {
    
    ListNode start = new ListNode(0);
    ListNode slow = start, fast = start;
    slow.next = head;
    
    //Move fast in front so that the gap between slow and fast becomes n
    for(int i=1; i<=n+1; i++)   {
        fast = fast.next;
    }
    //Move fast to the end, maintaining the gap
    while(fast != null) {
        slow = slow.next;
        fast = fast.next;
    }
    //Skip the desired node
    slow.next = slow.next.next;
    return start.next;
}