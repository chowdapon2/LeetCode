/*
147. Insertion Sort List
 Algorithm of Insertion Sort:

Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
It repeats until no input elements remain.

Example 1:

Input: 4->2->1->3
Output: 1->2->3->4
Example 2:

Input: -1->5->3->4->0
Output: -1->0->3->4->5

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
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        ListNode cur = head;

        // while loop for original list
        while(cur != null){
            ListNode sorted_list = dummy;
            ListNode next_unsorted_list = cur.next;

            //find insert position
            while(sorted_list.next != null && sorted_list.next.val < cur.val){
                sorted_list = sorted_list.next;
            }

            //insert node to sorted list
            ListNode temp = sorted_list.next;
            sorted_list.next = cur;
            cur.next = temp;

            // next node
            cur = next_unsorted_list;
        }
        return dummy.next;

    }
}

// other 4ms solution

class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode tail = head, p = head.next;
        while (p != null) {
            if (p.val >= tail.val) {
                tail.next = p;
                tail = p;
                p = p.next;
            } else {
                ListNode node = dummy;
                while (node.next.val <= p.val) {
                    node = node.next;
                }
                ListNode temp = p;
                p = p.next;
                temp.next = node.next;
                node.next = temp;
            }
        }
        tail.next = null;
        return dummy.next;
    }
}