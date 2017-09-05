/**
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
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
       public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null)
		    return l2;
		if (l2 == null)
		    return l1;
        ListNode outputList = new ListNode(0);
		ListNode p = l1, q = l2, tmp, current = outputList;
		int carry = 0, sum;
		while (p!=null || q!=null){
			sum = 0;
			sum += carry;
			if (p != null) {
				sum += p.val;
				p = p.next;
			}
			if (q != null) {
				sum += q.val;
				q = q.next;
			}
			//get carry by devided by 10
			tmp = new ListNode(sum % 10);
			carry = sum / 10;
			current.next = tmp;
			current = current.next;
		}
		//if there is a carry, add a new mode for ir
		if (carry == 1) {
			tmp = new ListNode(1);
			current.next = tmp;
			current = current.next;
		}
		current.next = null;
	return outputList.next;
    }
}