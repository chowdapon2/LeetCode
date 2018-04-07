/*
349. Intersection of Two Arrays
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.

範例
[1,2,2,3,1,2,2,2]
[2,2,2,3]

答案會是
[2,3]
*/


class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        //這個主要為了熟悉Set的應用
        //Set有add, contain兩個可用
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();
        //將num1加入set 1
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        //判斷nums2 中的數是否有在set1 有的話加入intersect set
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                intersect.add(nums2[i]);
            }
        }
        //取出intersect set並output
        int[] result = new int[intersect.size()];
        int i = 0;
        for (Integer num : intersect) {
            result[i++] = num;
        }
        return result;
    }
}