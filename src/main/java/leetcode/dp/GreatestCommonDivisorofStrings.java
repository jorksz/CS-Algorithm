package leetcode.dp;

/**
 * 题目
 * 字符串的最大公因子
 * https://leetcode-cn.com/problems/greatest-common-divisor-of-strings/
 */

public class GreatestCommonDivisorofStrings {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)){
            return "";
        }
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    private int gcd(int length, int length1) {
        return length1 == 0 ? length : gcd(length1, length % length1);
    }

    public static void main(String[] args) {
        String str1 = "abcabc";
        String str2 = "abc";

        GreatestCommonDivisorofStrings greatestCommonDivisorofStrings = new GreatestCommonDivisorofStrings();
        System.out.print(greatestCommonDivisorofStrings.gcdOfStrings(str1,str2));
    }
}

/**
 * 官方题解：
 * https://leetcode-cn.com/problems/greatest-common-divisor-of-strings/solution/
 */