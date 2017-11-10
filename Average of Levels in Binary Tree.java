/*
Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.

Example 1:
Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]
Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].


*/



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */ 
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        //output answer
        List<Double> answer = new ArrayList<Double>();
        
        //Queue for BFS
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        
        if (root == null) return answer;
        q.offer(root);
        while (!q.isEmpty()){
			//一次處理一層level
			
			//這層node數量
            int n = q.size();
			
            double sum = 0.0;
            for(int i = 0; i<n; i++){
                TreeNode node = q.poll();
                sum += node.val;
				//加到下層的Queue中
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            answer.add(sum / n);
        }
        return answer;
    }
}



//DFS
public class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        // list answer for sum all value in same level
        List<Double> answer = new ArrayList<Double>();
        
        // list counter for count number of node in same level
        List<Integer> counter = new ArrayList<Integer>();
        
        // using dfs to sum all value in same level and count number of node in same level
        dfs(0, root, answer, counter);
        
        // answer will be answer[level] / counter[level]
        for (int level = 0; level < answer.size(); level++) {
            answer.set(level, answer.get(level) / counter.get(level));
        }
        return answer;
    }

    public void dfs(int level, TreeNode node, List<Double> answer, List<Integer> counter) {
        if (node == null) {
            return;
        }

        if (answer.size() <= level) {
            answer.add(0.0);
            counter.add(0);
        }

        answer.set(level, answer.get(level) + node.val);
        counter.set(level, counter.get(level) + 1);

        // go left node and right node
        dfs(level + 1, node.left, answer, counter);
        dfs(level + 1, node.right, answer, counter);
    }
}