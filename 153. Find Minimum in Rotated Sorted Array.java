/**
153. Find Minimum in Rotated Sorted Array
Medium

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:

Input: [3,4,5,1,2] 
Output: 1
Example 2:

Input: [4,5,6,7,0,1,2]
Output: 0


 */

 class Solution {
    public int findMin(int[] nums) {
        int L = 0, R = nums.length - 1;
        while (L < R) {
            int M = (L + R) / 2;
            // if rotare or not
            // not rotate
            if(nums[L]<nums[R]){
                return nums[L];
            }else{
                if(nums[M]>=nums[L]){
                    // L~M is ascending, find M~R
                    // System.out.print(M);
                    L=M+1;
                }else{
                    // M~R is ascending, find L~M
                    R = M;
                }
            }
        
        }
        return nums[L];
    }
}