package niukeTop101.dp;

public class BM64MinCostClimbingStairs {

    /**
     * 每次最低就是最低花费
     *
     * 边界 1,2 步 0花费即可到达，所以dp[0],dp[1] 为0
     * 递推式 走下一步的花费为：dp[i-1] + cost[i-1]
     *       走下二步的花费： dp[i-2] + cost[i-2]
     *       取这两个走法的最小值即是当前dp[i]的最小花费，每次最小，就是最低花费
     *
     * @param cost
     * @return
     */
    public int minCostClimbingStairs (int[] cost) {
        // write code here
        int[] dp = new int[cost.length + 1];
        for (int i = 2;i <= cost.length; i++) {
            dp[i] = Math.min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2]);
        }
        return dp[cost.length];

    }

    public static void main(String[] args) {
        BM64MinCostClimbingStairs stairs = new BM64MinCostClimbingStairs();
        int[] cost = {2,5,20};
        System.out.println(stairs.minCostClimbingStairs(cost));

        int[] cost2 = {1,100,1,1,1,90,1,1,80,1};
        System.out.println(stairs.minCostClimbingStairs(cost2));
    }
}
