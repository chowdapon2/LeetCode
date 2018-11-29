/**
151. Reverse Words in a String
Given an input string, reverse the string word by word.

Example:  

Input: "the sky is blue",
Output: "blue is sky the".
Note:

A word is defined as a sequence of non-space characters.
Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
You need to reduce multiple spaces between two words to a single space in the reversed string.
Follow up: For C programmers, try to solve it in-place in O(1) space.
    
 */



 public class Solution {
    public String reverseWords(String s) {
        // 想法 : 有一個pointer紀錄最尾端的空白在哪邊
        // 如果不是空白 怎辦?
        // 判斷 for 的指標是否為0 或 指標的下一個是否為 ' '
        // 如果是 先看看回傳的裡面有沒有放東西 有 : 表示不是最尾端 加個 空白 進去 
        // 其他. 把i~j這段subString放到buffer
        
        StringBuilder reversed = new StringBuilder();
        int j = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
            j = i;
            }else if (i == 0 || s.charAt(i - 1) == ' ') {
                if (reversed.length() != 0) {
                    reversed.append(' ');
                }
                reversed.append(s.substring(i, j));
            }
        }
        return reversed.toString();
    }

}