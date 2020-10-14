package leetcode.character;

public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        String str = s + s;
        int len = str.length() - 1;
        return str.substring(1, len).contains(s);
    }

    public static void main(String[] args) {
        String str ="abcabc";
        RepeatedSubstringPattern repeatedSubstringPattern = new RepeatedSubstringPattern();
        System.out.println(repeatedSubstringPattern.repeatedSubstringPattern(str));
    }
}
