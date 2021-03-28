package leetcode.dp;

/**
 * @author lijt
 */
public class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

        // 定义状态  到达目的地src至少中转i（0-k)次
        int[][] dp = new int[n][K + 2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < K + 2; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < K + 2; i++) {
            dp[src][i] = 0;
        }

        for (int i = 1; i < K + 2; i++) {
            for (int[] flight : flights) {
                if (dp[flight[0]][i - 1] != Integer.MAX_VALUE) {
                    dp[flight[1]][i] = Math.min(dp[flight[1]][i], dp[flight[0]][i-1] + flight[2]);
                }
            }
        }

        return dp[dst][K+1] == Integer.MAX_VALUE ? -1 :  dp[dst][K+1];
    }

}
