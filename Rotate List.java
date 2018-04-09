/*
61. Rotate List

Given a list, rotate the list to the right by k places, where k is non-negative.
Example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
*/

//20ms
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        //count list length
        Queue<Integer> queue = new LinkedList<Integer>();
        ListNode count = head;
        while(count != null){
            queue.offer(count.val);
            count = count.next;
        }
        int len =queue.size();
        if(k==0 || len ==0){
            return head;
        }else{
            k %= len;
        }

        //use two pointer
        ListNode back = head;
        ListNode front = head;
        
        //move back pointer to k'th position
        for(int i=0; i<k;i++){
            back=back.next;
        }
        //insert the new value
        for(int i=0; i<len-k;i++){
            back.val = queue.poll();
            back=back.next;
        }
        //insert the new value from [0]
        for(int i=0; i<k;i++){
            front.val = queue.poll();
            front=front.next;
        }
        
        

        
        return head;
        
    }
}



//better solution 15ms

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        
        ListNode start = head;
        
        if(k == 0) { return start; }
        if(head == null) { return start; }
        int count = 0;
        
        
        
        //traverse till the end of the list and keep incrementing the count
        while(head.next != null) {
            head = head.next;
            count++;
        }
        count++;
        // if k > count, do k%count, its an optimization. 2%5 == 12%5
        k = k % count;
        //find the new k
        k = Math.abs(count - k);
        if (k == 0)
            return start;
        //connect last element to start	
        head.next = start;
        //traverse for new k value		
        while (k-- > 0) {
            head = head.next;
        }
        // note: head is not the last element, so set the start.
        start = head.next;
        head.next = null;
        return start;
        
    }
}