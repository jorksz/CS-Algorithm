package leetcode.array;

import java.util.Arrays;

public class CountPrimes {
    public int countPrimes(int n) {
        boolean[] isPrimes = new boolean[n];
        Arrays.fill(isPrimes, true);
        for (int i = 2; i * i < n; i++) {
            if (isPrimes[i]) {
                for (int j = i * i; j < n; j+=i) {
                    isPrimes[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < isPrimes.length; i++) {
            if (isPrimes[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountPrimes countPrimes = new CountPrimes();
        System.out.println(countPrimes.countPrimes(10));
    }
}
