package offer.dp;

public class TheMaximumValueOfGift {
    /**
     * 局部最优，整体最优。
     *
     * @param grid
     * @return
     */
    public int maxValue(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        dp[0][0] = grid[0][0];

        // 初始化边界，第一行值
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }

        // 初始化边界，第一列值
        for (int j = 1; j < m; j++) {
            dp[j][0] = dp[j - 1][0] + grid[j][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // dp 值为网格当前值，dp右边和下边最大值
                dp[i][j] = grid[i][j] + Math.max(dp[i - 1][j], dp[i][j-1]);
            }
        }

        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        TheMaximumValueOfGift maximumValueOfGift = new TheMaximumValueOfGift();
        int[][] grid = { {1,3,1},{1,5,1},{4,2,1}};
        System.out.println(maximumValueOfGift.maxValue(grid));
    }
}
