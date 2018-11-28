/**
739. Daily Temperatures




Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.

For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].

Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
 */

// stack解比較慢

 class Solution {
    public int[] dailyTemperatures(int[] T) {
        // Brute force : 2 for loop
        
        int[] result = new int[T.length];
        
        // use stack to store nearst  warmer index
        Stack<Integer> stack = new Stack<>();
        
        for(int i = T.length -1; i>=0; i--){
            while( !stack.isEmpty() && T[i] >= T[stack.peek()] ){
                stack.pop();
            }
            
            if(stack.isEmpty()){
                result[i]=0;
            }else{
                result[i] =stack.peek() - i;
            }
            stack.push(i);
             
        }
        
        return result;
    }
}

// 另一個解比較快

class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        int[] next = new int[101];
        Arrays.fill(next, Integer.MAX_VALUE);
        for (int i = T.length - 1; i >= 0; --i) {
            int warmer_index = Integer.MAX_VALUE;
            for (int t = T[i] + 1; t <= 100; ++t) {
                if (next[t] < warmer_index)
                    warmer_index = next[t];
            }
            if (warmer_index < Integer.MAX_VALUE)
                ans[i] = warmer_index - i;
            next[T[i]] = i;
        }
        return ans;
    }
}