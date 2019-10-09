package leetcode.character;

/**
 * 题目
 * 找出给出的字符串S中最长的回文子串。假设S的最大长度为1000，并且只存在唯一解。
 */

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        int maxLen = 0;
        String res = s.substring(0,1);
        for(int i = 0; i < 2* s.length() - 1; i++){
            int left = i/2;
            int right = i/2;
            //这里需要注意，如果用right来判断，无法满足 bb, abb这两种情况。需要用i来进行判断
            if(i % 2 == 1){
                right++;
            }
            String str = helper(s,left,right);

            if(maxLen < str.length()){
                maxLen = str.length();
                res = str;
            }
        }

        return res;
    }

    private String helper(String s, int left, int right) {

        while (left >=0 && right < s.length() && (s.charAt(left) == s.charAt(right))){
            left --;
            right ++;
        }

        return s.substring(left + 1, right);
    }


    public static void main(String[] args) {
        LongestPalindromicSubstring object = new LongestPalindromicSubstring();
        System.out.println(object.longestPalindrome("bb"));
    }

}

/**
 * 解题思路
 *
 * 1、利用左右两个指针，从中间往左右走，有点像那个滑动窗口这个概念。这里需要注意两个例子，一个是两个字符相同的情况aa和3个字符2个相同的情况abb
 * 需要用index来进行判断，不能用right指针来判断，否则无论如何都会略过一个test,复杂度为0（n*n),空间上为O（1）
 */