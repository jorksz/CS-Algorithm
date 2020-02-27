package leetcode.dp;

/**
 * 题目：爬楼梯
 * https://leetcode-cn.com/problems/climbing-stairs/
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n == 0){
            return 0;
        }

        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n ; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[dp.length -1];
    }

    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        System.out.println(climbingStairs.climbStairs(5));
    }
}


/**
 *不难发现，这个问题可以被分解为一些包含最优子结构的子问题，
 * 即它的最优解可以从其子问题的最优解来有效地构建，我们可以使用动态规划来解决这一问题。
 *
 * 第 i 阶可以由以下两种方法得到：
 *
 * 在第 (i-1) 阶后向上爬一阶。
 *
 * 在第 (i-2)阶后向上爬 2 阶。
 *
 * 所以到达第 i 阶的方法总数就是到第 (i-1) 阶和第 (i-2) 阶的方法数之和。
 *
 * 令 dp[i] 表示能到达第 i 阶的方法总数：
 *
 * dp[i]=dp[i-1]+dp[i-2]
 *
 * 作者：LeetCode
 * 链接：https://leetcode-cn.com/problems/climbing-stairs/solution/pa-lou-ti-by-leetcode/
 * 来源：力扣（LeetCode）
 */