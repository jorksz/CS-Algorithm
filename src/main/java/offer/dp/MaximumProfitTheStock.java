package offer.dp;

public class MaximumProfitTheStock {

    /**
     * 买必须在卖之前
     * 买在低点，卖再高点
     * 依次交替前进即可
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int profit = 0;
        int buy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            buy = Math.min(buy, prices[i]);
            profit = Math.max(profit, prices[i] - buy);
        }
        return profit;
    }

    public static void main(String[] args) {
        MaximumProfitTheStock maximumProfitTheStock = new MaximumProfitTheStock();
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maximumProfitTheStock.maxProfit(prices));
    }
}
