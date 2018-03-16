/*
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.
*/


class Solution {
    public int maxDepth(TreeNode root) {
        //BFS  tree level travel
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while(!queue.isEmpty()){
            int levelSize=queue.size();
            for(int i =0; i <levelSize; i++){
                TreeNode p =queue.poll();
                //add p's childen into queue
                if(p.left!=null) queue.add(p.left);
                if(p.right!=null) queue.add(p.right);                
            }
            level++;
        }
        return level;
    }
}





class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        
        //DFS, use two stack
        //one for node, one for node level value
        Stack<TreeNode> s= new Stack<>();
        Stack<Integer> value = new Stack<>();
        int max=0;
        s.push(root);
        value.push(1);
        while(!s.isEmpty()){
            TreeNode node = s.pop();
            int current = value.pop();
            max = Math.max(current,max);
            if(node.left != null){
                s.push(node.left);
                value.push(current+1);
            }//這裡不能加else  會變成or的用法
            if(node.right != null){
                s.push(node.right);
                value.push(current+1);
            }
        }
        
        return max;
        
        
    }
}