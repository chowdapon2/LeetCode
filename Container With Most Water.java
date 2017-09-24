/*
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines,
 which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.
*/


class Solution {
    public int maxArea(int[] height) {
        int temp = 0;
        int start = 0, end = height.length-1;
        int max = 0;
        
        for(int i =0; i< height.length-1; i++){
            //temp =(end-start)*(Math.min(height[start],height[end]));
            max = Math.max((end-start)*(Math.min(height[start],height[end])),max);
			//移動左右指標的依據: 根據該欄位的值判斷, 只移動比較小的, 因為小的就是buttle neck
            if (height[start]<height[end]){
                start++;
            }else{
                end--;
            }
        }
        
        
        return max;
    }

	
	//====================================================================
	//Better answer
	
	class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0, right = height.length - 1;

        while(left < right){
            if(height[left] <= height[right]){
                max = Math.max(max, (right-left)*height[left]);
               left++;
            }else{
                max = Math.max(max, (right-left)*height[right]);
                right--;
            }
        }
        
        return max;
    }
}