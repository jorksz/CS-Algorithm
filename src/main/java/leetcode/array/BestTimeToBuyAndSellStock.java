package leetcode.array;


/**
 * 题目
 *
 *假设你有一个数组，其中第i个元素是某只股票在第i天的价格。
 *如果你最多只能完成一笔交易(即买一股和卖一股股票)，设计一个算法来求最大利润。
 *
 * Say you have an array for which the i th element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction
 * (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 */


public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }

        int min = prices[0];
        int max = 0;
        for(int i = 0; i < prices.length; i++){
            min = Math.min(prices[i],min);
            max = Math.max(max,prices[i]-min);
        }

        return max;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();
        int[] prices = {1,2,3,4,6};
        System.out.println(bestTimeToBuyAndSellStock.maxProfit(prices));
    }
}

/**
 *解题思路
 *
 *核心就是在价格最低的时候买入，
 * 然后必须买入的后面时间才能卖出
 */