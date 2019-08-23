package leetcode.array;

/**
 * 题目
 *
 * 假设你有一个数组，其中第i个元素是某只股票在第i天的价格。
 * 设计一个算法来求最大的利润。你最多可以进行两次交易。
 * 注意:
 * 你不能同时进行多个交易(即，你必须在再次购买之前出售之前买的股票)。
 *
 * Say you have an array for which the i th element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 *
 * Note:
 * You may not engage in multiple transactions at the same time
 * (ie, you must sell the stock before you buy again).
 */


public class BestTimeToBuyAndSellStock3 {

    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }

        int firstB = Integer.MIN_VALUE;
        int firstS = 0;
        int secondB = Integer.MIN_VALUE;
        int secondS = 0;

        for(int i = 0; i < prices.length; i++){
            //第一次买
            firstB = Math.max(firstB,-prices[i]);
            //第一次卖
            firstS = Math.max(firstS,prices[i] + firstB);
            //第二次买
            secondB = Math.max(secondB, firstS - prices[i]);
            //第二次卖
            secondS = Math.max(secondS,prices[i] + secondB);
        }

        return secondS;

    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock3 bestTimeToBuyAndSellStock3 = new BestTimeToBuyAndSellStock3();
        int[] prices = {2,1,2,0,1};
        System.out.println(bestTimeToBuyAndSellStock3.maxProfit(prices));
    }
}
