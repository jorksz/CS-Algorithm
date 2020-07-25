package leetcode.array;

import java.util.Arrays;

public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[][] dp = new int[n+1][m+1];
        //初始化边界
        for (int i = 0; i <= n; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        int[] sum = new int[n+1];
        for (int i = 0; i < n; i++){
            sum[i+1] = sum[i] + nums[i];
        }

        dp[0][0] = 0;
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= Math.min(i,m); j++){
                for (int k = 0; k < i; k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j-1], sum[i] - sum[k]));
                }
            }
        }

        return dp[n][m];
    }
}
