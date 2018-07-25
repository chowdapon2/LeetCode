/*
 * [748] Largest Number At Least Twice of Others
 *
 * https://leetcode.com/problems/largest-number-at-least-twice-of-others/description/
 *
 * algorithms
 * Easy (40.55%)
 * Total Accepted:    24K
 * Total Submissions: 59.2K
 * Testcase Example:  '[0,0,0,1]'
 *
 * In a given integer array nums, there is always exactly one largest element.
 * 
 * Find whether the largest element in the array is at least twice as much as
 * every other number in the array.
 * 
 * If it is, return the index of the largest element, otherwise return -1.
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [3, 6, 1, 0]
 * Output: 1
 * Explanation: 6 is the largest integer, and for every other number in the
 * array x,
 * 6 is more than twice as big as x.  The index of value 6 is 1, so we return
 * 1.
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1, 2, 3, 4]
 * Output: -1
 * Explanation: 4 isn't at least as big as twice the value of 3, so we return
 * -1.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * nums will have a length in the range [1, 50].
 * Every nums[i] will be an integer in the range [0, 99].
 * 
 * 
 * 
 * 
 */
class Solution {
    public int dominantIndex(int[] nums) {
        //find max and it's index in nums
        int max = 0;
        int maxIndex = 0;

        //find second large value
        int second_max = 0;
        for(int i = 0; i<nums.length; i++){
            //find max and it's index in nums
            if (nums[i] > max){
                second_max = max;
                max = nums[i];
                maxIndex = i;
            
            //if nums[i] is in between max and second_max
            //then update second_max
            }else if(nums[i] > second_max && nums[i] != max){
                second_max = nums[i];
            }
        }
        if(max >= second_max*2){
            return maxIndex;
        }else{
            return -1;
        }
    }
}
