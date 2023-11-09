package offer.dp;

import java.util.Arrays;

public class NDiceCount {

    /**
     *
     * @param n
     * @return
     */
    public double[] dicesProbability(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0/6);
        for (int i = 2; i <= n; i++) {
            double[] temp = new double[i*5+1];
            for (int j = 0; j < dp.length;j++) {
                for (int k = 0; k < 6; k++) {
                    temp[j+k] += dp[j]/6;
                }
            }
            dp = temp;
        }
        return dp;
    }

    public static void main(String[] args) {
        NDiceCount nDiceCount = new NDiceCount();
        for (double d: nDiceCount.dicesProbability(2)) {
            System.out.println(d);
        }
    }
}
