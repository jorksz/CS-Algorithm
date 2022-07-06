package offer.dp;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        // dp
        int res = 0;
        int temp = 0;
        // 存最近重复字符的map ,字符->index
        Map<Character, Integer> charIndexMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            int index = charIndexMap.getOrDefault(s.charAt(i), -1);
            charIndexMap.put(s.charAt(i), i);
            if (temp < i - index) {
                temp = temp + 1;
            } else {
                temp = i - index;
            }
            res =Math.max(res, temp);
        }

        return res;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters characters = new LongestSubstringWithoutRepeatingCharacters();
        String s = "abcabcbb";
        System.out.println(characters.lengthOfLongestSubstring(s));
    }
}
