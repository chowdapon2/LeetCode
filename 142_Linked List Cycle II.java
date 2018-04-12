/*
142. Linked List Cycle II
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space?
*/

public class Solution {
    public ListNode detectCycle(ListNode head) {
        //use fast slow method
        ListNode slow = head;
        ListNode fast = head;

        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow){
                ListNode headstart = head; 
                while (headstart != slow){
                    slow = slow.next;
                    headstart = headstart.next;
                }
                return slow;
            }
        }
        return null;
    }
}