/*
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Example 1:

Input: [1,3,5,6], 5
Output: 2
Example 2:

Input: [1,3,5,6], 2
Output: 1
Example 3:

Input: [1,3,5,6], 7
Output: 4
Example 1:

Input: [1,3,5,6], 0
Output: 0
*/


class Solution {
    public int searchInsert(int[] nums, int target) {
        int length = nums.length;
        //array的長度是array.length  string的是string.length()
        for(int i =0; i< length;i++){
            if(target <=nums[i]){
                return i;
            }
        }
        return length;
        
    }
}
// binary seatch
class Solution {
    public int searchInsert(int[] A, int target) {
        int L = 0, R = A.length - 1;
        while (L < R) {
            int M = (L + R) / 2;
            if (A[M] < target) {
                L = M + 1;
            } else {
                R = M;
            }
        }
        return (A[L] < target) ? L + 1 : L;
    }
}