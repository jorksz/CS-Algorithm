package niukeTop101.dp;

public class BM80sellStocks {

    /**
     * 不断的迭代比较当前价格和最小价格差值，选取最大利益即可。
     * 需要注意买必须要在卖之前，所以先确定一个前后相比之下的较小值
     * @param prices int整型一维数组
     * @return int整型
     */
    public int maxProfit (int[] prices) {
        // write code here
        int profit = 0;
        int minProfit = prices[0];
        for (int i = 1; i < prices.length; i++) {
            minProfit = Math.min(prices[i], minProfit);
            if (prices[i] - minProfit > profit) {
                profit = prices[i] - minProfit;
            }
           /* if (prices[i] < minProfit) {
                minProfit = prices[i];
            } else if (prices[i] - minProfit > profit) {
                profit = prices[i] - minProfit;
            }*/
        }

        return profit;
    }

    public static void main(String[] args) {
        BM80sellStocks bm80sellStocks = new BM80sellStocks();
        int[] prices = {8,9,2,5,4,7,1};
        System.out.println(bm80sellStocks.maxProfit(prices));
    }
}
