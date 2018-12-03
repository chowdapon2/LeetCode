/*
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.
*/


class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0], sofar=nums[0];
        //記憶點: array的length沒有()
        for (int i = 1;i<nums.length ; i++){
            sofar = Math.max(nums[i], sofar+nums[i]);
            //記憶點 Math.Max要用max
            res = Math.max(res,sofar);
        }
        return res;
    }
}

======14ms=========
class Solution {
    public int maxSubArray(int[] nums) {
      	if(nums.length==1)return nums[0];
    	int result=nums[0];
    	int re=nums[0];
        for (int i = 1; i < nums.length; i++) {
			result=Math.max(result+nums[i], nums[i]);
			if(result>re){
				re=result;
			}
		}
        return re;
    }
}

class Solution {
    public int maxSubArray(int[] A) {
        // brute force solution
        // Memory Limit Exceeded
        
        // int ans = Integer.MIN_VALUE;
        // int len = A.length;
        // int[][] res = new int[len][len];
        // for(int i = 0; i<len ;i++){
        //     for(int j=i; j< len ; j++){
        //         if (i==j){
        //             res[i][j]=A[i];
        //             ans = Math.max(res[i][j], ans);
        //         }else{
        //             res[i][j]= A[j] + res[i][j-1];
        //             ans = Math.max(res[i][j], ans);
        //         }
        //     }   
        // }
        // return ans;
        
        // brute force solution 2 withour A[][]
        // int ans = Integer.MIN_VALUE;
        // int len = A.length;
        // int[] temp = new int[len];
        // for(int i = 0; i<len ;i++){
        //     for(int j=i; j< len ; j++){
        //         if (i==j){
        //             temp[j] = A[j];
        //             ans = Math.max(temp[j], ans);
        //         }else{
        //             temp[j] = temp[j-1]+A[j];
        //             ans = Math.max(temp[j], ans);
        //         }
        //     }
        // }
        // return ans;
        
        //solution 3 no temp[len]
        // f(k) = max( f(k-1) + A[k], A[k] )
        int maxEndingHere = A[0], maxSoFar = A[0];
            for (int i = 1; i < A.length; i++) {
            maxEndingHere = Math.max(maxEndingHere + A[i], A[i]);
            maxSoFar = Math.max(maxEndingHere, maxSoFar);
            }
        return maxSoFar;
    }
}
/*
Algo解釋
=====中文=====
當你已經求到Ai-1的位置時 要如何延伸到Ai的位置呢?
這時候的答案要嘛在1~i-1的序列中或是第i個位置 所以是用max (A[i], sofar+A[i])


algorithm that operates on arrays: it starts at the left end (element A[1]) 
and scans through to the right end (element A[n]), 
keeping track of the maximum sum subvector seen so far. 
The maximum is initially A[0]. 
Suppose we’ve solved the problem for A[1 … i - 1]; how can we extend that to A[1 … i]? The maximum
sum in the first I elements is either the maximum sum in the first i - 1 elements 
(which we’ll call MaxSoFar), or it is that of a subvector that ends in position i (which we’ll call MaxEndingHere).

MaxEndingHere is either A[i] plus the previous MaxEndingHere, or just A[i], whichever is larger.
*/