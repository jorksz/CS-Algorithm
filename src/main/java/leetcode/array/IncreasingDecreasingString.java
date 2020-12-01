package leetcode.array;

import java.util.Arrays;

public class IncreasingDecreasingString {
    public String sortString(String s) {
        char[] chars = s.toCharArray();
        int[] bucket = new int[26];
        for (int i = 0; i < chars.length; i++) {
            bucket[chars[i] - 'a']++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (stringBuilder.length() < chars.length) {
            for (int i = 0; i < 26; i++) {
                if (bucket[i] != 0) {
                    stringBuilder.append((char)(i + 'a'));
                    bucket[i]--;
                }
            }

            for (int i = 25; i >= 0; i--) {
                if (bucket[i] != 0) {
                    stringBuilder.append((char)(i + 'a'));
                    bucket[i]--;
                }
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        IncreasingDecreasingString increasingDecreasingString = new IncreasingDecreasingString();
        System.out.println(increasingDecreasingString.sortString("rat"));
    }
}
