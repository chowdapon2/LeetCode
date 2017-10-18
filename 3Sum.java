/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/


//Time limit exceed
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> outputList = new ArrayList<>();  
        if(nums == null || nums.length <= 2)
            return outputList;
        
        // Sort the input array
        Arrays.sort(nums);

        

        //i = front, j = middle, k=end
        for(int i =0; i< nums.length -2 && nums[i]<=0; i++){
            int min = nums[i];
            
            //skip same integer
            if (i>0 && nums[i-1]==nums[i]) continue;
            
            int j=i+1; //middle
            int k=nums.length-1; //end
            while(j<k){
                int sum =min+nums[j]+nums[k];
                if (sum == 0){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(i);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    outputList.add(list);
                    
                    /* avoid duplicate;*/
                    while(j<k && nums[j] == nums[j+1])
                        j ++;
                    while(j<k && nums[k] == nums[k-1])
                        k --;
                }else if (sum<0){
                    j++;
                }else{
                    k++;
                }
                
            }  
        }
        return outputList;
    }
}








//good Answer
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
		//Sort
        Arrays.sort(nums);
        List<List<Integer>> outputList = new ArrayList<>();
        int middle, end, sum;
        for(int i=0;i<nums.length-2;i++){
            middle = i+1;
            end = nums.length - 1;
            while(middle<end){
                //System.out.println("Checending " + nums[i] + " , " + nums[middle] + " , " + nums[end]);
                sum = nums[i] + nums[middle] + nums[end];
                if (sum == 0){
                  List<Integer> ls = new ArrayList<Integer>();
                  ls.add(nums[i]);
                  ls.add(nums[middle]);
                  ls.add(nums[end]);
                  outputList.add(ls);
                  middle++;end--;
                  while(middle<end && nums[end]==nums[end+1]) end--;//to avoid duplicates
                  while(middle<end && nums[middle]==nums[middle-1]) middle++;//to avoid duplicates
                } else if (sum > 0){
                    end--;
                    while(middle<end && nums[end]==nums[end+1]) end--;//optional skip for non-zero triplets
                } else {
                    middle++;
                    while(middle<end && nums[middle]==nums[middle-1]) middle++;//optional skip for non-zero triplets
                }
            }
            while(i<nums.length-2 && nums[i]==nums[i+1]){ //to avoid duplicates
                i++;
            }
        }
        return outputList;
    }
}


//Memory Limit Exceeded
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> outputList = new ArrayList<>();
        if(nums == null || nums.length <= 2)
            return outputList;
        
        // Sort the input array
        Arrays.sort(nums);
        
        //i = front, j = middle, k=end
        for(int i =0; i< nums.length -2; i++){
            int min = nums[i];
            
            // no zero sum possible
            if (min > 0) break;
            
            //skip same integer
            if (i>0 && nums[i-1]==nums[i]) continue;
            
            int j=i+1; //middle
            int k=nums.length-1; //end
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if (sum == 0){
                    outputList.add(Arrays.asList(min, nums[j], nums[k]));
                    
                    /* avoid duplicate;*/
                    while(j<k && nums[j] == nums[j+1])
                        j ++;
                    while(j<k && nums[k] == nums[k-1])
                        k --;
                }else if (sum<0){
                    j++;
                }else{
                    k++;
                }
                
            }  
        }
        return outputList;
    }
}

//66ms Better answer
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2 && nums[i] <= 0; i++) {
            if( i > 0 && nums[i] == nums[i-1])
                continue;
            int target = -nums[i];
            int j=i+1,k=nums.length-1;
            while(j<k ){
                if(nums[j] + nums[k] > target){
                    k--;
                }else if(nums[j] + nums[k] < target){
                    j++;
                }else{
                    result.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    k--;
                    j++;
                    while(j<k && j>i+1 && nums[j]==nums[j-1]){
                        j++;
                    }
                    while(j<k && k<nums.length-1 && nums[k]==nums[k+1]){
                        k--;
                    }
                }
            }
        }
        return result;
    }
}

//60ms
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return Collections.emptyList();
        }

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for (int end = nums.length - 1; end >= 2 && nums[end] >= 0; end--) {

            //Filter duplication
            if (end < nums.length - 1 && nums[end] == nums[end + 1]) {
                continue;
            }

            // Two sum && filter duplication
            int target = 0 - nums[end], first = 0, last = end - 1;
            while (first < last) {
                if (nums[first] + nums[last] < target) {
                    first++;
                } else if (nums[first] + nums[last] > target) {
                    last--;
                } else {
                    result.add(Arrays.asList(nums[first], nums[last], nums[end]));
                    first++;
                    last--;

                    //Filter duplication
                    while (first <= last && nums[first] == nums[first - 1]) {
                        first++;
                    }
                    while (last >= first && nums[last] == nums[last + 1]) {
                        last--;
                    }

                }
            }
        }

        return result;
    }
}