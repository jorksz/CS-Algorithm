package leetcode.dp;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0) {
            return 0;
        }

        if (cost.length == 1) {
            return cost[0];
        }

        int[] dp = new int[cost.length];
        dp[0] = 0;
        dp[1] = Math.min(cost[0], cost[1]);
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min((dp[i-1] + cost[i]), (dp[i-2] + cost[i-1]));
        }
        return dp[cost.length-1];
    }

    public static void main(String[] args) {
        MinCostClimbingStairs stairs = new MinCostClimbingStairs();
        int[] costs = {10, 15, 20};
        System.out.println(stairs.minCostClimbingStairs(costs));
    }
}
