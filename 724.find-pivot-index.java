/*
 * [724] Find Pivot Index
 *
 * https://leetcode.com/problems/find-pivot-index/description/
 *
 * algorithms
 * Easy (39.25%)
 * Total Accepted:    27.8K
 * Total Submissions: 70.9K
 * Testcase Example:  '[1,7,3,6,5,6]'
 *
 * Given an array of integers nums, write a method that returns the "pivot"
 * index of this array.
 * 
 * We define the pivot index as the index where the sum of the numbers to the
 * left of the index is equal to the sum of the numbers to the right of the
 * index.
 * 
 * If no such index exists, we should return -1. If there are multiple pivot
 * indexes, you should return the left-most pivot index.
 * 
 * 
 * Example 1:
 * 
 * Input: 
 * nums = [1, 7, 3, 6, 5, 6]
 * Output: 3
 * Explanation: 
 * The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the
 * sum of numbers to the right of index 3.
 * Also, 3 is the first index where this occurs.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: 
 * nums = [1, 2, 3]
 * Output: -1
 * Explanation: 
 * There is no index that satisfies the conditions in the problem statement.
 * 
 * 
 * 
 * Note:
 * The length of nums will be in the range [0, 10000].
 * Each element nums[i] will be an integer in the range [-1000, 1000].
 * 
 */
class Solution {
    public int pivotIndex(int[] nums) {
        if (nums.length == 0) return -1;
        int rightSum = 0;
        int leftSum = 0;
        for (int i : nums){
            rightSum += i;
        }

        for(int j=0 ; j<nums.length; j++){
            rightSum -=nums[j];
            if(leftSum == rightSum){
                return j;
            }else{
                leftSum += nums[j];
            }
        }
        return -1;
    }
}


/**
18% solution
class Solution {
    public int pivotIndex(int[] nums) {
        int total = 0;
        int leftsum = 0;
        for (int num : nums) total += num;
        for (int i = 0; i < nums.length; leftsum += nums[i++]){
            if (leftsum * 2 + nums[i] == total) return i; 
        }
        return -1;
        
    }
}


 */