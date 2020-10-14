package leetcode.character;

import com.sun.deploy.util.SyncAccess;

public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int len = s.length();
        int res = 0;
        for (int i = 0; i < len; i++){
            res += helper(s, i, i, len);
            res += helper(s, i, i+1, len);
        }
        return res;
    }

    private int helper(String s, int i, int j, int len) {
        int res = 0;
        while (i >= 0 && j < len && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
            res ++;
        }
        return res;
    }

    public static void main(String[] args) {
        PalindromicSubstrings palindromicSubstrings = new PalindromicSubstrings();
        String s = "aaa";
        System.out.println(palindromicSubstrings.countSubstrings(s));
    }
}
