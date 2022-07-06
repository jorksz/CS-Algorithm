package offer.dp;

public class NumberOfUgly {

    /**
     * 最开始是想通过遍历判断丑数来返回目标值，但后边发现遍历终点不确定，最终采取 dp，核心是后一个丑数必定是前边某个值通过 2,3,5倍数得来的
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        int xIndex = 0;
        int yIndex = 0;
        int zIndex = 0;
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int xValue = dp[xIndex] * 2;
            int yValue = dp[yIndex] * 3;
            int zValue = dp[zIndex] * 5;
            dp[i] = Math.min(Math.min(xValue, yValue), zValue);
            if (xValue == dp[i]) {
                xIndex++;
            }
            if (yValue == dp[i]) {
                yIndex++;
            }
            if (zValue == dp[i]) {
                zIndex++;
            }
        }
        return dp[n-1];
    }

    /**
     * 丑数判断
     * @param num
     * @return
     */
    private boolean isUgly(int num) {
        while (num % 2 == 0) {
            num = num / 2;
        }
        while (num % 5 == 0) {
            num = num / 5;
        }
        while (num % 3 == 0) {
            num = num / 3;
        }
        return num == 1;
    }

    public static void main(String[] args) {
        NumberOfUgly numberOfUgly = new NumberOfUgly();
        System.out.println(numberOfUgly.nthUglyNumber(10));
    }
}
