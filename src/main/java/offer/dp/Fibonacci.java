package offer.dp;

/**
 * 剑指 Offer 10- I. 斐波那契数列
 */
public class Fibonacci {
    public int fib(int n) {
        // 大小多声明2位，存储dp[0,1]
        int[] dp = new int[n+2];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            // 按要求取模
            dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.fib(4));
        System.out.println(fibonacci.fib(0));
        System.out.println(fibonacci.fib(45));
        System.out.println(fibonacci.fib(5));
        System.out.println(fibonacci.fib(48));
    }
}
