/*
 * [167] Two Sum II - Input array is sorted
 *
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 *
 * algorithms
 * Easy (47.40%)
 * Total Accepted:    159.6K
 * Total Submissions: 336.6K
 * Testcase Example:  '[2,7,11,15]\n9'
 *
 * Given an array of integers that is already sorted in ascending order, find
 * two numbers such that they add up to a specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they
 * add up to the target, where index1 must be less than index2.
 * 
 * Note:
 * 
 * 
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may
 * not use the same element twice.
 * 
 * 
 * Example:
 * 
 * 
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 * 
 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        int front = 0;
        int last = len-1;
        int temp = 0;

        while(last > front){
            temp = numbers[front]+numbers[last];
            if(temp==target){
                break;
            }else{
                if(temp>target){
                    last--;
                }else{
                    front++;
                }
            }
        }
        int[] res = {front+1,last+1};
        return res;
    }
}
