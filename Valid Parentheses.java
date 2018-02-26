
/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i =0; i<s.length() ; i++){//length後面要記得加()
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                stack.push(s.charAt(i));
            }else if(s.charAt(i) ==')' && !stack.empty() && stack.peek() == '('){
                stack.pop();
            }else if(s.charAt(i) ==']' && !stack.empty() && stack.peek() == '['){
                stack.pop();
            }else if(s.charAt(i) =='}' && !stack.empty() && stack.peek() == '{'){
                stack.pop();
            }else{
                return false;
            }
        }
        return stack.isEmpty();//isEmpty E要大寫
    }
}


==========================