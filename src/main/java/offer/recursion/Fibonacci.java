package offer.recursion;

/**
 * 斐波那契数列
 *
 * 大家都知道斐波那契数列，现在要求输入一个整数n，
 * 请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 */

public class Fibonacci {

    public int Fibonacci(int n) {

        if(n <= 0){
            return n;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++){
            dp[i] = dp[i-2] + dp[i-1];
        }

        return dp[n-1];
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.Fibonacci(1));
    }
}

/**
 * 单纯的递归如果n过大，会出现堆栈溢出，而且递归会出现大量的重复运算
 *
 * 这里采用动态规划求解，动态规划递推式： dp[i] = dp[i-2]+dp[i-1];
 *
 * 注意最后返回的数值应该是n-1的index
 */