/*
328. Odd Even Linked List
Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example:
Given 1->2->3->4->5->NULL,
return 1->3->5->2->4->NULL.
*/

//my wrong answer
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next.next==null) return head;
        int count = 3;
        ListNode oddNode = head;
        ListNode evenNode = head.next;
        ListNode evenNodeStart = head.next;
        ListNode current = head.next.next;
        while(current!=null){
            if(1 == (count%2)){
                oddNode.next = current;
                oddNode = oddNode.next;
                current = current.next;
                count++;
            }
            if(0 ==(count%2)){
                evenNode.next = current;
                evenNode = evenNode.next;
                current = current.next;
                count++;
            }
        }
        //connet two list
        oddNode.next = evenNodeStart;
        
        return head;
    }
}

//right answer
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode odd=head,ehead=head.next,even=ehead;
        while(even!=null&&even.next!=null){
            odd.next=even.next;
            odd=odd.next;
            even.next=odd.next;
            even=even.next;
        }
        odd.next=ehead;
        return head;
    }
}

//更好懂
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode odd=head,ehead=head.next,even=ehead;
        while(even!=null&&even.next!=null){
            odd.next = odd.next.next; 
            even.next = even.next.next; 
            odd = odd.next;
            even = even.next;
        }
        odd.next=ehead;
        return head;
    }
}