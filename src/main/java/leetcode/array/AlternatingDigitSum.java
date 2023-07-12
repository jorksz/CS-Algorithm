package leetcode.array;

public class AlternatingDigitSum {

    public int alternateDigitSum(int n) {
        String nString = String.valueOf(n);
        int nStringLen = nString.length();
        int sum = 0;
        for (int i = 0; i < nStringLen; i++) {
            int sum1 = Integer.parseInt(String.valueOf(nString.charAt(i)));
            if (i % 2 == 0) {
                sum += sum1;
            } else {
                sum -= sum1;;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        AlternatingDigitSum alternatingDigitSum = new AlternatingDigitSum();
        int n = 521;
        System.out.println(alternatingDigitSum.alternateDigitSum(n));
        n = 111;
        System.out.println(alternatingDigitSum.alternateDigitSum(n));
        n = 886996;
        System.out.println(alternatingDigitSum.alternateDigitSum(n));
    }
}
