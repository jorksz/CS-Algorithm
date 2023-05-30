package niukeTop101.dp;

import leetcode.character.MagicalString;

public class BM73 {

    public int getLongestPalindrome (String A) {
        // write code here
        int maxLen = 1;
        for (int i = 0; i < A.length() -1; i++) {
            maxLen = Math.max(maxLen, Math.max(fun(A, i, i), fun(A, i, i+1)));
        }

        return maxLen;
    }


    public int fun(String s, int begin, int end){
        //每个中心点开始扩展
        while(begin >= 0 && end < s.length() && s.charAt(begin) == s.charAt(end)){
            begin--;
            end++;
        }
        //返回长度
        return end - begin - 1;
    }

    public static void main(String[] args) {
        String s = "abbba";
        BM73 bm73 = new BM73();
        System.out.println(bm73.getLongestPalindrome(s));
    }
}
