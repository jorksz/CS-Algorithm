package leetcode.character;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * 给定一个字符串s和一组单词dict，在s中添加空格将s变成一个句子，使得句子中的每一个单词都是dict中的单词
 * 返回所有可能的结果
 * 例如：给定的字符串s ="catsanddog",
 * dict =["cat", "cats", "and", "sand", "dog"].
 *
 * 返回的结果为["cats and dog", "cat sand dog"].
 */


public class WordBreak2 {

    public List<String> wordBreak(String s, List<String> wordDict) {
        ArrayList<String> res = new ArrayList<>();
        if(s == null || s.length() == 0){
            return res;
        }
        helper(res, s, 0, wordDict, "");
        return res;
    }

    private void helper(ArrayList<String> res, String s, int start, List<String> wordDict, String str) {
        if(start == s.length()) {
            res.add(str);
        }
        else {
            StringBuilder stringBuilder = new StringBuilder();
            for(int i = start; i < s.length(); i++){
                stringBuilder.append(s.charAt(i));
                if(wordDict.contains(stringBuilder.toString())){
                    String tempStr = str.length() > 0 ?
                            (str + " " + stringBuilder.toString()) : stringBuilder.toString();
                    helper(res, s, i+1, wordDict, tempStr);
                }
            }
        }

    }


    /**
     * 第二种解法，从后往前
     * @param s
     * @param dict
     * @return
     */
    public ArrayList<String> wordBreak2(String s, List<String> dict) {
        ArrayList<String> res = new ArrayList<>();
        if(s == null || s.length() == 0){
            return res;
        }


        helper2(res, s, s.length(), dict, "");

        return res;
    }

    /**
     *从后往前递归，顺序就对了
     * @param res
     * @param s
     * @param start
     * @param dict
     * @param str
     */
    private void helper2(ArrayList<String> res, String s, int start, List<String> dict, String str) {
        if(start <= 0){
            if(str.length() > 0){
                res.add(str.substring(0, str.length() - 1));
            }
        }

        for(int i = start; i >= 0; i--){
            if(dict.contains(s.substring(i, start))){
                helper2(res,s, i, dict, s.substring(i, start) +" " + str );
            }
        }
    }

    public static void main(String[] args) {
        WordBreak2 wordBreak2 = new WordBreak2();
        List<String> dict = new ArrayList<>();
        dict.add("cat");
        dict.add("cats");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");

        String s = "catsanddog";

        System.out.println(wordBreak2.wordBreak2(s,dict));
    }
}

/**
 *解题思路
 *
 * 都是递归暴力求解，两种解法只是遍历的顺序不同，但思想还是一样的
 * 每次维护一个当前结果集，然后遍历剩下的所有子串，如果子串在字典中出现，则保存一下结果，并放入下一层递归剩下的字符
 */

