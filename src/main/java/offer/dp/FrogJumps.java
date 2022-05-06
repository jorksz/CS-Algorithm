package offer.dp;

/**
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 */
public class FrogJumps {

    public int numWays(int n) {
        int[] dp = new int[n + 2];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        FrogJumps frogJumps = new FrogJumps();
        System.out.println(frogJumps.numWays(7));
    }
}
