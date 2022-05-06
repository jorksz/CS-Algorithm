package offer.dp;

/**
 * 剑指 Offer 19. 正则表达式匹配
 */
public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {

        int sLen = s.length() + 1;
        int pLen = p.length() + 1;
        boolean[][] dp = new boolean[sLen][pLen];

        dp[0][0] = true;

        for (int i = 2; i < pLen; i++) {
            dp[0][i] = dp[0][i - 2] && p.charAt(i - 1) == '*';
        }

        for (int i = 1; i < sLen; i++) {
            for (int j = 1; j < pLen; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2] || (dp[i - 1][j] && s.charAt(i - 1) == p.charAt(j - 2)) || (dp[i - 1][j] && p.charAt(j-2) == '.');
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] && s.charAt(i - 1) == p.charAt(j - 1)) || (dp[i - 1][j - 1] && p.charAt(j - 1) == '.');
                }

            }
        }

        return dp[sLen - 1][pLen - 1];
    }
}
