package leetcode.dp;

public class OnesAndZeroes {
    public int findMaxForm(String[] strs, int m, int n) {

        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];

        for (int i = 1; i <= strs.length; i++) {

            int[] countZeroAndOne = countZeroAndOne(strs[i - 1]);

            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = dp[i-1][j][k];

                    if (j >= countZeroAndOne[0] && k >= countZeroAndOne[1]) {
                        dp[i][j][k] = Math.max(dp[i-1][j][k], dp[i-1][j - countZeroAndOne[0]][k - countZeroAndOne[1]] + 1);
                    }
                }
            }
        }

        return dp[strs.length][m][n];
    }

    private int[] countZeroAndOne(String str) {
        int[] res = new int[2];

        for (int i = 0; i < str.length(); i++) {
            res[str.charAt(i) - '0'] ++;
        }
        return res;
    }

    public static void main(String[] args) {
        OnesAndZeroes onesAndZeroes =  new OnesAndZeroes();
        String[] strings = {"10", "0001", "111001", "1", "0"};
        System.out.println(onesAndZeroes.findMaxForm(strings, 5, 3));
    }
}
