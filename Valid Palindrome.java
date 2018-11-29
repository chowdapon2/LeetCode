/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.

*/
//我的, 用到stack  浪費時間
class Solution {
    public boolean isPalindrome(String s) {
       
        String lows = s.toLowerCase();
        //remove all comma
        // 
        
        //need to reserve 0~9, so replaceAll turn to
        lows = lows.replaceAll("[^a-z0-9]","");
        
        int len=lows.length();
	    if(len<2)
		    return true;
        
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0;i<len; i++){
            stack.push(lows.charAt(i));
        }
        StringBuilder reverse = new StringBuilder();
        
        while(!stack.isEmpty()){
            reverse.append(stack.pop().toString());
        }
        System.out.println(reverse);
        System.out.println(lows);
        
        if(lows.equals(reverse.toString())){
            return true;
        }else{
            return false;
        }
    }
}



//不用stack
sample 12 ms submission
class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder str = new StringBuilder();
        for(char c:s.toCharArray()){
            if(c<='Z'&&c>='A'||c<='z'&&c>='a'||c<='9'&&c>='0'){
                str.append(c);
            }
        }
        String str1=str.toString().toLowerCase();
        String str2=str.reverse().toString().toLowerCase();
        return str1.equals(str2);
        
    }
}

// 4ms
class Solution {
    public boolean isPalindrome(String s) {
        // 1. sol
        // use stack + StringBuffer  => super slow
        
        // 2. two pointer with isAlphanumeric(), s.charAt(i)
        int len = s.length();
        
        int start = 0;
        int end = len-1;
        
        while(start < end){
            while(start < end && !isAlphanumeric(s.charAt(start))) start++;
            while(start < end && !isAlphanumeric(s.charAt(end))) end--;
            if(Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))){
                return false; 
            }
            start++; end--;
        }
        return true; 
    }
    
    public static boolean isAlphanumeric(char c) {
        return (c <= 'Z' && c >= 'A') || (c <= 'z' && c >= 'a') ||(c>='0'&&c<='9');
    }
}