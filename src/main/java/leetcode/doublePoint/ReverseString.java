package leetcode.doublePoint;

import java.util.Arrays;

/**
 * @author lijt
 */
public class ReverseString {
    /**
     * API 解决
     * @param s
     */
    public void reverseString(char[] s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s) {
            sb.append(c);
        }
        String s1 = sb.reverse().toString();
        for (int i = 0; i < s.length; i++) {
            s[i] = s1.charAt(i);
        }

        System.out.println(new String(s));
    }

    /**
     * 原地修改数组
     *
     * @param s
     */
    public void reverseString2(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }

        int front = 0;
        int back = s.length - 1;

        while (front < back) {
            char frontTempChar = s[front];
            char backTempChar = s[back];
            s[front++] = backTempChar;
            s[back--] = frontTempChar;
        }

        System.out.println(Arrays.toString(s));
    }

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        reverseString.reverseString(new char[]{'a','b'});

        reverseString.reverseString2(new char[]{'a','b'});
    }
}
