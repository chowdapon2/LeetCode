/*
 * @lc app=leetcode id=1221 lang=java
 *
 * [1221] Split a String in Balanced Strings
 */

// @lc code=start
class Solution {
    public int balancedStringSplit(String s) {
        if (s.length()%2 != 0){
            return 0;
        }
        Stack<Character> stack = new Stack<>();
        int count =0;
        for(int i =0; i<s.length(); i++){
            if(!stack.empty()){
                if(s.charAt(i) == 'R'){
                    if(stack.peek() == 'R'){
                        stack.push(s.charAt(i));
                    }else{
                        stack.pop();
                        if(stack.empty()){
                            count++;
                        }
                    }
                }else{
                    if(stack.peek() == 'L'){
                        stack.push(s.charAt(i));
                    }else{
                        stack.pop();
                        if(stack.empty()){
                            count++;
                        }
                    }
                }
            }else{
                // System.out.println("empty, add char");
                stack.push(s.charAt(i));
            }
        }
        return count;
    }
}
// @lc code=end

