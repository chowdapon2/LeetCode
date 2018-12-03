/**
152. Maximum Product Subarray
Medium

Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

 */
class Solution {
    public int maxProduct(int[] A) {
        // f(k) = Largest product subarray, from index 0 up to k.
        // Similarly,
        // g(k) = Smallest product subarray, from index 0 up to k.
        // Then,
        // f(k) = max( f(k-1) * A[k], A[k], g(k-1) * A[k] )
        // g(k) = min( g(k-1) * A[k], A[k], f(k-1) * A[k] )
        // assert A.length > 0;
        // int max = A[0], min = A[0], maxAns = A[0];
        // for (int i = 1; i < A.length; i++) {
        //     int mx = max, mn = min;
        //     System.out.println("mx : "+mx+" mn : "+ mn );
        //     max = Math.max(Math.max(A[i], mx * A[i]), mn * A[i]);
        //     min = Math.min(Math.min(A[i], mx * A[i]), mn * A[i]);
        //     maxAns = Math.max(max, maxAns);
        // }
        // return maxAns;
        int max = A[0], min = A[0], gm = A[0];
        for(int i=1; i<A.length; i++) {
            int a = A[i];
            if(a > 0) {
                max = Math.max(max*a, a);
                min = Math.min(min*a, a);
            } else if(a == 0) {
                max = 0;
                min = 0;
            } else {
                int prevMax = max;
                max = Math.max(a, min*a);
                min = Math.min(a, prevMax*a);
            }
            gm = Math.max(gm, max);
        }
        return gm;
    }
}