Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?



class Solution {
    public int singleNumber(int[] nums) {
        //HashSet<int> set = new HashSet<int>();
        //上面complime失敗, 因為裡面是container, 不能用int 藥用大寫的Integer
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i :nums){
            if(set.contains(i)){
                set.remove(i);
            }else{
                set.add(i);
            }
        }
           
        Iterator iterator = set.iterator();
        return (int)iterator.next();
    }
}


//用XOR的方式
/*
Approach #4 Bit Manipulation [Accepted]

Concept

If we take XOR of zero and some bit, it will return that bit
a⊕0 = a
a⊕a =0
a⊕b⊕a=b
*/

class Solution {
    public int singleNumber(int[] nums) {
        int result=0;
        for(int i=0;i<nums.length;i++){
            result = result ^ nums[i];
        }
        return result;
    }
}

//用數學的方式
// 2* (a+b+c)−(a+a+b+b+c)=c