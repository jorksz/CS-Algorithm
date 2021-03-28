package leetcode.dp;

public class HouseRobber {
    /**
     * 递推公式：
     *这一次不偷
     * dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
     * 这一次偷东西 =上次不投的数量+当前金额数量
     * dp[i][1] = dp[i-1][0] + nums[i];
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + nums[i];
        }
        return Math.max(dp[nums.length - 1][0], dp[nums.length-1][1]);
    }

    public static void main(String[] args) {
        HouseRobber houseRobber = new HouseRobber();
        int[] nums = new int[]{1,2,3,1};
        System.out.println(houseRobber.rob(nums));
    }
}
