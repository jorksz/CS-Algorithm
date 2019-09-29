package leetcode.character;

import java.util.ArrayList;


/**
 * 题目
 *
 * 给定一个字符串s，分割s使得s的每一个子串都是回文串
 * 返回所有的回文分割结果
 * 例如:给定字符串s="aab",
 * 返回
 *   [↵    ["aa","b"],↵    ["a","a","b"]↵  ]
 */


public class PalindromePartitioning {

    public ArrayList<ArrayList<String>> partition(String s) {
        if(s == null || s.length() == 0){
            return new ArrayList<>();
        }

        ArrayList<ArrayList<String>> res = new ArrayList<>();

        helper(res, 0, s, new ArrayList<>());

        return res;
    }

    private void helper(ArrayList<ArrayList<String>> res, int start, String s, ArrayList<String> temp) {
        if(start == s.length() ){
            res.add(new ArrayList<>(temp));
            return;
        }else{
            for(int i = start ; i < s.length(); i++){
                if(isPalindrome(s.substring(start, i + 1))){
                    temp.add(s.substring(start, i + 1));
                    helper(res, i+1, s, temp);
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }

    private boolean isPalindrome(String substring) {
        if(substring == null || substring.length() == 0){
            return false;
        }

        int start = 0;
        int end = substring.length() - 1;

        while(start < end){
            if(substring.charAt(start ++) != substring.charAt(end --)){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning palindromePartitioning = new PalindromePartitioning();
        System.out.println(palindromePartitioning.partition("aab"));
    }
}

/**
 *正经的回溯，只是需要一个判断是否为回文的方法，通过两指针前后扫，当字符相同时，即可判断为回文
 *
 * 注意下递归的时候，start需要用i来进行递归，否则会出现单独的字符值
 *
 */