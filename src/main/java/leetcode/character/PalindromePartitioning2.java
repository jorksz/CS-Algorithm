package leetcode.character;

public class PalindromePartitioning2 {

    public int minCut(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        int[] dp = new int[s.length()];

        for(int i = 0; i < dp.length; i++){
            dp[i] = isPalindrome(s.substring(0,i + 1)) ? 0 : i;

            if(dp[i] != 0){
                for(int j = i; j > 0; j--){
                    if(isPalindrome(s.substring(j, i+ 1))) {
                        dp[i] = Math.min(dp[i], dp[j - 1] +1);
                    }
                }
            }
        }

        return dp[dp.length - 1];



    }

    private boolean isPalindrome(String substring) {
        if(substring == null || substring.length() == 0){
            return false;
        }

        int start = 0;
        int end = substring.length() - 1;

        while(start < end){
            if(substring.charAt(start ++) != substring.charAt(end --)){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning2 palindromePartitioning2 = new PalindromePartitioning2();
        System.out.println(palindromePartitioning2.minCut("aab"));
    }
}


/**
 * 解题思路
 *
 * dp[i]表示s.substring(0, i + 1)子串的回文最小切割数，
 * (Java子字符串函数满足左闭右开特点，i+1表示包含第i个字符)
 * 显然最终结果为dp[s.length - 1]。
 *
 * 确认初始状态：
 * dp[0] = 0,1个字符不用切割
 * 当子串是回文串时，dp[i] = 0，
 * 否则dp[i]初值等于i（最坏的情况），
 * 即整个子串不存在回文子字符串，需要切割i次成单个字符
 * 确认状态转移方程：
 * 当s.substring(j, i + 1) (1 <= j <= i)是回文时，
 * dp[i] = min(dp[i], dp[j - 1] + 1)。
 * 即用变量j遍历i之前的每个子串，注意判断是否回文，是则重新给dp[i]赋值
 *
 * 来自牛客网
 */