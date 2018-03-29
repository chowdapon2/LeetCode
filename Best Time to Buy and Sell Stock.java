/*
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Example 1:
Input: [7, 1, 5, 3, 6, 4]
Output: 5

max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
Example 2:
Input: [7, 6, 4, 3, 1]
Output: 0

In this case, no transaction is done, i.e. max profit = 0.
*/

// Time Limit Exceeded
class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
         for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                res = Math.max(res, prices[j]-prices[i]);
            }
        }
        
        if(res >0){
            return res;
        }else{
            return 0;
        }
    }
}

//正確解  
class Solution {
    public int maxProfit(int[] prices) {
        //提示,參照 max sub Array max(A[i], sofar+A[i])
        //每前進一位, 等於要把之前賣的價位還回去, 補上新的價位
        //所以, sofar要加上A[i]-A[i-1]的值
        //但是sofar算是目前的profit 有可能減完變負數, 所以跟0取max
        int maxprofit = 0;
        int sofar =0;
        for(int i = 1;i<prices.length;i++){
            sofar = Math.max(0, sofar+prices[i]-prices[i-1]);
            maxprofit = Math.max(sofar,maxprofit);
        }
        return maxprofit;
    }
}