/*Topic
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],
Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
*/


public class Solution {
    public int removeDuplicates(int[] input) {
        if (input == null || input.length <= 1) return input.length;
        int len = 0;
        for (int i =0 ; i < input.length; i++){
            if (input[len] != input[i]){
                len++;
                input[len]= input[i];
            }
        }
        return len+1;
    }
}