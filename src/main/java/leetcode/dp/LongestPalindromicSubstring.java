package leetcode.dp;


/**
 * 最长回文子串
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        // 回文串的右边界 index
        int rightIndex = 1;
        // 回文串的左边界 index
        int begin = 0;
        // s[i,j+1] 是否为回文子串
        boolean[][] dp = new boolean[len][len];
        // 初始化边界，因为 dp[i][j](i = j) 都是一个回文子串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] chars = s.toCharArray();
        for (int j = 2; j <= len; j++) {
            for (int i = 0; i < len; i++) {
                int k = i + j - 1;
                if (k >= len) {
                    break;
                }
                if (chars[i] != chars[k]) {
                    dp[i][k] = false;
                } else {
                    if (k - i < 3) {
                        dp[i][k] = true;
                    } else {
                        dp[i][k] = dp[i+1][k-1];
                    }
                }
                if (dp[i][k] && k - i + 1 > rightIndex) {
                    begin = i;
                    rightIndex = k - i + 1;
                }
            }
        }
        return s.substring(begin, begin + rightIndex);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        System.out.println(longestPalindromicSubstring.longestPalindrome("aba"));
    }


}
