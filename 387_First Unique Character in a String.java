/*
387. First Unique Character in a String

Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
*/

//bad solution 3.17% 151ms
class Solution {
    public int firstUniqChar(String s) {
        int len = s.length();
        if(len==0) return -1;
        Stack<Character> stack = new Stack<Character>();
        HashMap<Character,Integer> hash = new HashMap<Character,Integer>();
        
        for(int i =0; i<len ; i++){

            stack.push(s.charAt(i));
            
            if(hash.containsKey(s.charAt(i))){
                hash.put( s.charAt(i),hash.get(s.charAt(i))+1 );
            }else{
                hash.put(s.charAt(i),1);
            }
        }
        
        int index = len;
        
        //if there is no non-repeating character
        if(!hash.containsValue(1)) return -1;
        
        for(int i=len-1; i>=0; i--){
            if(hash.get(stack.pop()) ==1){
                index =i;
            }
        }
        return index;
    }
}

//29ms
/*重點在char-'a'
只要新建一個26大小的array即可
*/
public class Solution {
    public int firstUniqChar(String s) {
        int freq [] = new int[26];
        for(int i = 0; i < s.length(); i ++)
            freq [s.charAt(i) - 'a'] ++;
        for(int i = 0; i < s.length(); i ++)
            if(freq [s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }
}


