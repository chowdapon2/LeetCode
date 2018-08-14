/*
 * [14] Longest Common Prefix
 *
 * https://leetcode.com/problems/longest-common-prefix/description/
 *
 * algorithms
 * Easy (31.84%)
 * Total Accepted:    306.8K
 * Total Submissions: 963.6K
 * Testcase Example:  '["flower","flow","flight"]'
 *
 * Write a function to find the longest common prefix string amongst an array
 * of strings.
 * 
 * If there is no common prefix, return an empty string "".
 * 
 * Example 1:
 * 
 * 
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * 
 * 
 * Note:
 * 
 * All given inputs are in lowercase letters a-z.
 * 
 */

 //others faster solution
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length < 1) return "";
        StringBuilder prefix = new StringBuilder();
        
        int charIndex = 0;
        while (charIndex != strs[0].length())
        {
            char c = strs[0].charAt(charIndex);
            for (int i = 1; i < strs.length; i++)
            {
                if (strs[i].length() == charIndex || strs[i].charAt(charIndex) != c) return prefix.toString();
            }
            charIndex++;
            prefix.append(c);
        }
        return prefix.toString();    
    }
}
