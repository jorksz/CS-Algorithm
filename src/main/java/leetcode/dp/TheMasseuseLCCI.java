package leetcode.dp;


public class TheMasseuseLCCI {
    public int massage(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int[][] dp = new int[nums.length][2];
        dp[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + nums[i];
        }
        return Math.max(dp[nums.length - 1][0], dp[nums.length-1][1]);
    }

    public static void main(String[] args) {
        TheMasseuseLCCI tg = new TheMasseuseLCCI();
        int[] nums = {1,2,3,1};
        System.out.println(tg.massage(nums));
    }
}
