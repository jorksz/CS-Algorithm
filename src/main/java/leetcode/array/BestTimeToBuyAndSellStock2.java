package leetcode.array;


/**
 * 题目
 *
 * 假设你有一个数组，其中第i个元素表示某只股票在第i天的价格。
 * 设计一个算法来寻找最大的利润。你可以完成任意数量的交易(例如，多次购买和出售股票的一股)。
 * 但是，你不能同时进行多个交易(即，你必须在再次购买之前卖出之前买的股票)。
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit.
 * You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times).
 * However, you may not engage in multiple transactions at the same time
 * (ie, you must sell the stock before you buy again).
 */


public class BestTimeToBuyAndSellStock2 {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }

        int res = 0;
        for(int i = 1; i < prices.length; i++){
            int max = Math.max(0, prices[i] - prices[i-1]);
            if(max > 0){
                res += max;
            }
        }

        return res;
    }


    public static void main(String[] args) {
        BestTimeToBuyAndSellStock2 bestTimeToBuyAndSellStock2 = new BestTimeToBuyAndSellStock2();
        int[] prices = {2,1};
        System.out.println(bestTimeToBuyAndSellStock2.maxProfit(prices));
    }

}

/**
 *解题思路
 *
 * 这里只需理解成只要每次卖出利益大于0 就可以有利润，所以把每次的利润加起来就是最大利润了
 */