/*

169. Majority Element
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.
*/


//34ms
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        int len = nums.length;
        for(int i =0; i<len ; i++){
            if(m.containsKey(nums[i])){
                m.put(nums[i],m.get(nums[i])+1);
            }else{
                m.put(nums[i],1);
            }
        }
        int max = 0;
        int res = Integer.MIN_VALUE;
        for (Integer key : m.keySet()) {
            // System.out.println(key + " : " + map.get(key));
            if(max < m.get(key)){
                max = m.get(key);
                res = key;
            }
        }
        return res;
    }
}

//另一種方式, 用sort, 因為一定會有n/2個以上的數  所以把sort後在n/2位置的值return就一定是解了
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}


//2ms Boyer-Moore Voting Algorithm [
class Solution {
    public int majorityElement(int[] nums) {
        int count=0, ret = 0;
        for (int num: nums) {
            if (count==0)
                ret = num;
            if (num!=ret)
                count--;
            else
                count++;
        }
        return ret;
    }
}