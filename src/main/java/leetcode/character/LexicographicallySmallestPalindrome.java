package leetcode.character;

import java.util.Arrays;

public class LexicographicallySmallestPalindrome {

    public String makeSmallestPalindrome(String s) {
        if (s == null) {
            return null;
        }
        char[] characters = s.toCharArray();
        int startIndex = 0;
        int endIndex = s.length() - 1;
        while (startIndex < endIndex) {
            if (s.charAt(startIndex) != s.charAt(endIndex)) {
                characters[startIndex] = characters[endIndex] = (char) Math.min(s.charAt(startIndex), s.charAt(endIndex));
            }
            startIndex++;
            endIndex--;
        }
        return new String(characters);
    }

    public static void main(String[] args) {
        String s = "egcfe";
        LexicographicallySmallestPalindrome lexicographicallySmallestPalindrome = new LexicographicallySmallestPalindrome();
        System.out.println(lexicographicallySmallestPalindrome.makeSmallestPalindrome(s));

        s = "abcd";
        System.out.println(lexicographicallySmallestPalindrome.makeSmallestPalindrome(s));
    }
}
