/**
Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
 */
 
 //4ms  
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if( null==headA || null==headB )
			return null;
        ListNode lA = headA;
        ListNode lB = headB;
        int totalcount = length(headA)+length(headB);
        int count = 0;
        while(lA !=lB){
            if(lA.next!=null){
                lA = lA.next;
            }else{
                lA= headB;
            }
            if(lB.next!=null){
                lB = lB.next;
            }else{
                lB = headA;
            }
            count++;
            if(count>totalcount) return null;
        }
        return lA;
    }
    
    private int length(ListNode node) {
        int length = 0;
        while (node != null) {
            node = node.next;
            length++;
        }
        return length;
    }
}

//others better solution 1ms
//先對其, 然後開尻
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int aLen = 0,bLen = 0;
        ListNode curA = headA,curB = headB;
        while (curA != null) {
            aLen++;
            curA = curA.next;
        }
        while (curB != null){
            bLen++;
            curB = curB.next;
        }

        curA = headA;
        curB = headB;
        if(aLen > bLen){
            for (int i = aLen - bLen; i > 0; i--) {
                curA = curA.next;
            }
        }else{
            for (int i = bLen - aLen; i > 0; i--) {
                curB = curB.next;
            }
        }
        
        while (curA != curB){
            curA = curA.next;
            curB = curB.next;
        }

        return curA;
    }
}

