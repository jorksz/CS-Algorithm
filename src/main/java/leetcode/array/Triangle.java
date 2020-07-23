package leetcode.array;

import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[][] dp = new int[size][size];
        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < size; i++){
            dp[i][0] = dp[i-1][0] + triangle.get(i).get(0);

            for (int j = 1; j < i; j++){
                dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j]) + triangle.get(i).get(j);
            }
            dp[i][i] = dp[i-1][i-1] + triangle.get(i).get(i);
        }
        int res = dp[size -1][0];

        for (int i = 1; i < size; i++){
            res = Math.min(dp[size-1][i], res);
        }

        return res;
    }
}
