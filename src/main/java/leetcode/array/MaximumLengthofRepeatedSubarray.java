package leetcode.array;

public class MaximumLengthofRepeatedSubarray {
    public int findLength(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int res = 0;
        int[][] dp = new int[m+1][n+1];
        for (int i = m - 1; i>=0 ;i--){
            for (int j = n - 1; j >= 0; j--){
                dp[i][j] = A[i] == B[j] ? dp[i+1][j+1] + 1 : 0;
                res = Math.max(dp[i][j], res);
            }
        }
        return res;
    }
}
