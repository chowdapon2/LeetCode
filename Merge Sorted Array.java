/*
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) 
to hold additional elements from nums2. 
The number of elements initialized in nums1 and nums2 are m and n respectively.
*/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //hint : from back to forth
        //from nums[0] start, we need to create a new array
        //from back we don't need to create a new array
        int i = m - 1;
        int j = n - 1;
        int end = m+n-1;
        
        while(j >=0 && i >=0 ){
            if( nums1[ i ] > nums2[ j ] ){
                nums1[ end] = nums1[i];
                end--;
                i--;
            }
            else{
                nums1[end] = nums2[j];
                end--;
                j--;
            }      
        }
        
        //in nums2 longer than nums1 situation
        while( j >= 0 ){
            nums1[end] = nums2[j];
            end--;
            j--;
        }
            
        //return nums1;
    }
}