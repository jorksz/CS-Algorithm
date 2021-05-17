package leetcode.array;

/**
 * @author lijt
 */
public class NumberOfWaysToStayInTheSamePlaceAfterSomeSteps {
    public int numWays(int steps, int arrLen) {
        final int mod = 1000000007;
        // 步数超过一半回不来
        int maxLen = Math.min(steps/2, arrLen - 1);
        int[][] dp = new int[steps + 1][maxLen + 1];
        dp[0][0] = 1;
        // i 是可以走到 steps 步的，所以要 <=
        for (int i = 1; i <= steps; i++) {
            for (int j = 0; j <= maxLen; j++) {
                // 原地
                dp[i][j] = dp[i-1][j];
                // 靠左走
                if (j >= 1) {
                    dp[i][j] = (dp[i][j] + dp[i-1][j-1]) % mod;
                }
                // 靠右走
                if (j + 1 <= maxLen) {
                    dp[i][j] = (dp[i][j] + dp[i-1][j+1]) % mod;
                }
            }
        }
        return dp[steps][0];
    }

    public static void main(String[] args) {
        NumberOfWaysToStayInTheSamePlaceAfterSomeSteps number = new NumberOfWaysToStayInTheSamePlaceAfterSomeSteps();
        int steps = 4;
        int arrLen = 3;
        System.out.println(number.numWays(steps, arrLen));
    }
}
