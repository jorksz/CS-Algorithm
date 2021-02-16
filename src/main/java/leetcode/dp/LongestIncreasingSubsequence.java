package leetcode.dp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        // 状态定义， 最大序列长度为状态
        int[] dp = new int[len];
        // 既然最大序列长度是状态，那么初始值也就是最大序列长度至少都是1
        Arrays.fill(dp, 1);

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < len; i++) {
            res = Math.max(dp[i], res);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] tesr = {4,10,4,3,8,9};
        LongestIncreasingSubsequence subsequence = new LongestIncreasingSubsequence();
        System.out.println(subsequence.lengthOfLIS(tesr));
    }
}
