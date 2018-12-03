/**
138. Copy List with Random Pointer
Medium

A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.


 */

 /**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
//     public RandomListNode copyRandomList(RandomListNode head) {
//         // brute force 1. while loop O(n) on 'next' pointer
//         // 2. while loop O(n) on 'Randon' pointer
//         RandomListNode dummy = new RandomListNode(0);
//         RandomListNode cur_node = head;
//         RandomListNode new_node = dummy;
      
      
//         // 1. while loop O(n) on 'next' pointer
//         while(cur_node != null){
//             new_node.next =  new RandomListNode(cur_node.label);;
//             new_node = new_node.next;
//             cur_node = cur_node.next;
//         }
        
//         // 2.while loop O(n) on 'Randon' pointer
//         // move two pointer to first place
//         cur_node = head;
//         new_node = dummy;
//         while(cur_node != null){
//             new_node.next.random = cur_node.random;
//             new_node = new_node.next;
//             cur_node = cur_node.next;
//         }
        
//         return dummy.next;
        
//     }
    
    // the other solution
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode p = head;
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode q = dummy;
        while (p != null) {
            q.next = new RandomListNode(p.label);
            map.put(p, q.next);
            p = p.next;
            q = q.next;
        }
        p = head;
        q = dummy;
        while (p != null) {
            q.next.random = map.get(p.random);
            p = p.next;
            q = q.next;
        }
        return dummy.next;
    }
    
}