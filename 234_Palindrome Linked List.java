/*
234. Palindrome Linked List
Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?
*/
//my 7ms
class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<Integer>();
        ListNode p = head;
        while(p!=null){
            stack.push(p.val);
            p = p.next;
        }
        while(!stack.isEmpty()){
            if(head.val!=stack.pop()){
                return false;                
            }else{
                head = head.next;
            }
        }
        return true;
    }
}

//別人的絕佳解
//想法slow 跟 fast, fast 走兩倍距離
/*
    while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
    }
    if (fast != null) { // odd nodes: let right half smaller
        slow = slow.next;
    }
tricky的點在於
要判斷fast的跟fast的next是否為null才走
最終如果fast不等於null
表示右邊比較長一點, 多一個, 所以是奇數的node數
所以要把slow往右邊移一格
*/
This can be solved by reversing the 2nd half and compare the two halves. Let’s start with an example [1, 1, 2, 1].

In the beginning, set two pointers fast and slow starting at the head.

1 -> 1 -> 2 -> 1 -> null 
sf
(1) Move: fast pointer goes to the end, and slow goes to the middle.

1 -> 1 -> 2 -> 1 -> null 
          s          f
(2) Reverse: the right half is reversed, and slow pointer becomes the 2nd head.

1 -> 1    null <- 2 <- 1           
h                      s
(3) Compare: run the two pointers head and slow together and compare.

1 -> 1    null <- 2 <- 1             
     h            s
public boolean isPalindrome(ListNode head) {
    ListNode fast = head, slow = head;
    while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
    }
    if (fast != null) { // odd nodes: let right half smaller
        slow = slow.next;
    }
    slow = reverse(slow);
    fast = head;
    
    while (slow != null) {
        if (fast.val != slow.val) {
            return false;
        }
        fast = fast.next;
        slow = slow.next;
    }
    return true;
}

public ListNode reverse(ListNode head) {
    ListNode prev = null;
    while (head != null) {
        ListNode next = head.next;
        head.next = prev;
        prev = head;
        head = next;
    }
    return prev;
}


/////另一個解, 這個解釋reverse前半段的list
//如果遇到奇數node數, 將最後指的pointer往前一個
//   r = len % 2 == 0 ? p : r;
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        // detect the length
        int len = 0;
        for (ListNode p = head; p != null; p = p.next) len++;
        // reverse the first half list
        ListNode p = head, q = null, r = p.next;
        for (int i = 0; i < len / 2; i++) {
            p.next = q;
            q = p;
            p = r;
            r = r.next;
        }
        // detect the palindrome from the mid
        r = len % 2 == 0 ? p : r;
        while (r != null && q != null) {
            if (r.val != q.val) return false;
            r = r.next;
            q = q.next;
        }
        return r == null && q == null;
    }
}
