package leetcode.character;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;


/**
 * 题目
 * 给定一个字符串s和一组单词dict，判断s是否可以用空格分割成一个单词序列，
 * 使得单词序列中所有的单词都是dict中的单词（序列可以包含一个或多个单词）。
 * 例如:
 * 给定s=“leetcode”；
 * dict=["leet", "code"].
 * 返回true，因为"leetcode"可以被分割成"leet code".
 *
 * Given a string s and a dictionary of words dict,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * For example, given
 * s ="leetcode",
 * dict =["leet", "code"].
 *
 * Return true because"leetcode"can be segmented as"leet code".
 */

public class WordBreak {

    public static boolean wordBreak(String s, Set<String> dict) {
        if(s == null || s.length() == 0){
            return true;
        }

        boolean[] res = new boolean[s.length() + 1];
        res[0] = true;
        for(int i = 0; i < s.length(); i++){
            StringBuilder stringBuilder = new StringBuilder(s.substring(0,i+1));
            for(int j = 0; j <= i; j++){
                if(res[j] && dict.contains(stringBuilder.toString())){
                    res[i + 1] = true;
                    break;
                }

                stringBuilder.deleteCharAt(0);
            }
        }

        return res[s.length() ];
    }

    public static void main(String[] args) {
        Set<String> dict = new LinkedHashSet<>();
        dict.add("dog");
        dict.add("s");
        dict.add("gs");
        System.out.println(wordBreak("a",dict));

        System.out.println(dict);
    }
}
