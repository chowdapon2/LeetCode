
/*Longest Palindromic Substring
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example:

Input: "babad"

Output: "bab"

Note: "aba" is also a valid answer.
Example:

Input: "cbbd"

Output: "bb"
*/



public class Main {

    public static void main(String[] args) {
	// write your code here

        String t = "baaacaaa";
        String o= longestPalindrome(t);
        System.out.println(""+ o);
        System.out.println("t.substring(0,1);"+ t.substring(1,2));

    }
    static public String longestPalindrome(String s) {
        char[] ca = s.toCharArray();
        System.out.println("turn String into Char");
        int start = 0, end = 0;
        int max = 0;
        for (int i = 0; i < ca.length; i++) {
            System.out.println("for loop i:"+ i);
            if (isPalindrome(ca, i - max - 1, i)) {
                start = i - max - 1;
                end = i;
                max += 2;
                System.out.println("start = "+ start);
                System.out.println("end = "+ end);
                System.out.println("max = "+ max);
            } else if (isPalindrome(ca, i - max, i)) {
                start = i - max;
                end = i;
                max += 1;
                System.out.println("start = "+ start);
                System.out.println("end = "+ end);
                System.out.println("max = "+ max);
            }
            System.out.println("==================================");
        }
        return s.substring(start, end + 1);
    }

    private static boolean isPalindrome(char[] ca, int s, int e) {
        System.out.printf("s = %d, e= %d \n", s, e);
        if(s < 0) return false;
        while(s < e) {
            if(ca[s++] != ca[e--]) return false;
        }
        return true;
    }

}


//另一個solution, 從每個String的中間往外擴散的
public class Solution {
	int palinStart = 0;
	int palinLen = 0;
	public String longestPalindrome(String s) {
		if(s.length()<2 || s==null) return s;
		char[] chars = s.toCharArray();
		for(int i=0; i<chars.length-1; i++){
			checkThisPos(chars, i, i);
			checkThisPos(chars, i, i+1);
		}
		return s.substring(palinStart, palinStart+palinLen);
	}
	public void checkThisPos(char[] chars, int left, int right){
		while(left>=0 && right<chars.length && chars[left]==chars[right]){
			left--;
			right++;
		}	
		if(right-left-1>palinLen){
			palinLen = right-left-1;
			palinStart = left+1;
	// System.out.println("palinStart: "+ palinStart+" palinLen: "+palinLen);
		}



