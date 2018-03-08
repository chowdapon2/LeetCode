/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

Example:

Input: "Hello World"
Output: 5
*/
/*===我的7ms=====*/
class Solution {
    public int lengthOfLastWord(String s) {
        String[] separated = s.split(" ");
        int strLength = separated.length;
        if(strLength == 0){return 0;}
        return separated[strLength-1].length();
    }
}


/*別人的5ms*/

class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int lastIndex = s.lastIndexOf(' ') + 1;
        return s.length() - lastIndex;        
    }
}