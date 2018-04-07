/*
350. Intersection of Two Arrays II

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

Follow Up 

Q1: What if the given array is already sorted? How would you optimize your algorithm?

A: 采用solution 2

Q2: What if nums1's size is small compared to nums2's size? Which algorithm is better?

A: 如果nums1相对于nums2非常小，那么把nums1做成哈希表，哈希表占用空间更小

Q3: What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

A：

如果只有nums2不能放在内存中，则将nums1做成哈希表，nums2分批加载到内存中处理。(If only nums2 cannot fit in memory, put all elements of nums1 into a HashMap, read chunks of array that fit into the memory, and record the intersections.)

如果nums1和nums2都很大，都不适合储存在内存，那么就用外部排序分别来sort它们。将每2G(举例)读入内存，使用2指针技术，然后从内存中读取更多的2G。重复此操作，直到没有更多数据从磁盘读取。(If both nums1 and nums2 are so huge that neither fit into the memory,  
sort them using external sort, read (let’s say) 2G of each into memory and then using the 2 pointer technique, 
then read 2G more from the array that has been exhausted. Repeat this until no more data to read from disk.)

*/

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int len1=nums1.length;
        int len2=nums2.length;
        // if(len1==0 || len2==0) return null;
        
        //錯誤點Array.sort(nums1);, 要用Arrays
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i =0;
        int j =0;
        Stack<Integer> stack= new Stack<Integer>();
        while(i<len1 && j<len2){
            if(nums1[i] < nums2[j]){
                i++;
            }else if(nums1[i] > nums2[j]){
                j++;
            }else{
               stack.push(nums1[i]);
                i++;
                j++;
            }
        }
        
        int[] res = new int[stack.size()];
        int cur=0;
        while(!stack.isEmpty()){
            res[cur] = stack.pop();
            cur++;
        }
        return res;
    }
}


//不用stack 用list的方式
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int pnt1 = 0;
        int pnt2 = 0;
        ArrayList<Integer> myList = new ArrayList<Integer>();
        while((pnt1 < nums1.length) &&(pnt2< nums2.length)){
            if(nums1[pnt1]<nums2[pnt2]){
                pnt1++;
            }
            else{
                if(nums1[pnt1]>nums2[pnt2]){
                    pnt2++;
                }
                else{
                    myList.add(nums1[pnt1]);
                    pnt1++;
                    pnt2++;
                }
            }
        }
        int[] res = new int[myList.size()];
        for(int i = 0; i<res.length; i++){
            res[i] = (Integer)myList.get(i);
        }
        return res;    
    }
}