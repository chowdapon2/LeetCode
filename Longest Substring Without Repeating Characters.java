/*
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3.
Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/


class Solution {
        public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int start = -1, end = 0, output=0;
        while(end < s.length()){
            char key = s.charAt(end);
            if (map.containsKey(key)){//Not map.contain, is map.containsKey
                int newstart = map.get(key);
                start = Math.max(start,newstart);
            }
            map.put(key,end);
            output = Math.max(output,end-start);//Not Max(), is Math.max()
            end++;
        }
        return output;
    }
}