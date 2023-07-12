package leetcode.maths;

public class FindThePivotInteger {

    public int pivotInteger(int n) {

        if (n == 1) {
            return 1;
        }
        int sum = ((1 + n) * n)/ 2;

        int sum2 = n;
        for (int i = n; i >= 1; i--) {
            sum -= i;
            sum2 += i - 1 ;
            if (sum == sum2) {
                return i-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindThePivotInteger findThePivotInteger = new FindThePivotInteger();
        findThePivotInteger.pivotInteger(8);
    }
}
