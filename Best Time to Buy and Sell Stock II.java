/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like 
(ie, buy one and sell one share of the stock multiple times). 
However, you may not engage in multiple transactions at the same time 
(ie, you must sell the stock before you buy again).
*/


class Solution {
    public int maxProfit(int[] prices) {
        /*想法: 畫圖來看的話, 把Y軸設成value, x軸為array位置
        畫出來的曲線圖, 可以看出  答案就是把所有只要是坡度向上的落差加起來就是答案
        */
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }
}