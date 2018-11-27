/**
23. Merge k Sorted Lists

Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6


 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return partition(lists, 0, lists.length - 1);
        
    }
    
    private ListNode partition(ListNode[] lists, int start, int end) {
        if (start == end) return lists[start]; 
        if (start < end) {
            int mid = start + (end - start) / 2;
            ListNode left = partition(lists, start, mid);
            ListNode right = partition(lists, mid + 1, end);
            return merge(left, right);
        }
        else {
            return null;
        }
    }
    
    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l2.val > l1.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        }else {
            l2.next =  merge(l1, l2.next);
            return l2;
        }
    }    
    
//     public ListNode mergeKLists(ListNode[] lists) {
//         if (lists.length == 0 ) return null;
//         if( lists.length == 1 ) return lists[0];
//         if(lists.length == 1) return lists[0];
          
//         for(int i = 1; i < lists.length; i++){
//             lists[0]= merge(lists[0], lists[i]);
//         }
//         return lists[0];
        
//     }
    
//      public ListNode merge(ListNode l1, ListNode l2){
//         if(l1 == null) return l2;
//         if(l2 == null) return l1;
//         if(l1.val > l2.val){
//             l2.next = merge(l1, l2.next);
//             return l2;
//         }
//         else{
//             l1.next = merge(l1.next, l2);
//             return l1;
//         }
//     }
}