/**
101. Symmetric Tree
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isSym(root,root);
    }
    
    boolean isSym(TreeNode p,TreeNode q){
        //need to judge 3 place
        //1. layer 1 node is same
        //2. p->left == q->right
        //3. p->right == q->left
        if(p == null && q == null){
            return true;
        }else if (p == null || q == null){
            return false;
        }else if(p.val == q.val){
            return isSym(p.left , q.right) && isSym(p.right, q.left);
        }else{
            return false;
        }
    }
}

/*Iteration.
Approach #2 (Iterative) [Accepted]
Instead of recursion, we can also use iteration with the aid of a queue. 
Each two consecutive nodes in the queue should be equal, and their subtrees a mirror of each other. 
Initially, the queue contains root and root. 
Then the algorithm works similarly to BFS, with some key differences. 
*/

class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode p = queue.poll();
            TreeNode q = queue.poll();
            if(p==null && q ==null)continue;
            if(p==null || q==null) return false;
            if(p.val != q.val){
                return false;
            }else{
                queue.add(p.left);  //1 in note picture
                queue.add(q.right); //2
                queue.add(p.right); //3
                queue.add(q.left);  //4
                continue;
            }
        }
        return true;
    }
    
    
}