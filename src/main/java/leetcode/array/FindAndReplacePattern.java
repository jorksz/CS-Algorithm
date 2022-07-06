package leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAndReplacePattern {

    /**
     * 题目看了一会才明白，简单来说就 word 中的字符匹配 pattern 里边的，同时 pattern 也需要匹配 word,双向匹配，
     * 但又不能出现一个字符映射另外一个字符串里边的两个及以上字符,题目里边这两字符串长度都是相同的
     *
     * 所以思路遍历word,用个Map 来记录映射规则，检测 word 匹配 pattern，pattern 匹配 word
     * @param words
     * @param pattern
     * @return
     */
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for (String str :words) {
            if (match(str, pattern) && match(pattern, str)) {
                res.add(str);
            }
        }

        return res;
    }

    private boolean match(String str, String pattern) {
        Map<Character,Character>  map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            char p = pattern.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, p);
            } else if (map.get(c) != p) {
                return false;
            }
        }

        return true;

    }

    public static void main(String[] args) {
        FindAndReplacePattern findAndReplacePattern = new FindAndReplacePattern();
        String[] words = {"abc","deq","mee","aqq","dkd","ccc"};
        String pattern = "abb";
        System.out.println(findAndReplacePattern.findAndReplacePattern(words, pattern));
    }
}
