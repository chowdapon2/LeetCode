/*
189. Rotate Array
Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
*/

class Solution {
    public void rotate(int[] nums, int k) {
        // Queue<Integer> queue = new Queue<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        int len = nums.length;
        if(len<k) k=k%len;
        int mid = len-k;
        for(int i = mid; i<len; i++) {
            queue.offer(nums[i]);
        }
        for(int j = 0; j<mid ; j++){
            queue.offer(nums[j]);
        }
        for(int l = 0; l<len;l++){
            nums[l] = queue.poll();
        }
    }
}

//別人的好的解法
class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length; 
        int[] temp = new int[k];
        int t = nums.length - k;
        int s = t-1;
        for (int i = 0; i < k; i++) {
            temp[i] = nums[t++];
        }
        for (int j = nums.length - 1; j >= k; j--) {
            nums[j] = nums[s--];
        }
        for (int z = 0; z < k; z++) {
            nums[z] = temp[z];
        }
    }
}