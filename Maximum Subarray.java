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