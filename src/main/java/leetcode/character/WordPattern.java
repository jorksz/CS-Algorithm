package leetcode.character;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] strings = s.split(" ");
        if (strings.length != pattern.length()) {
            return false;
        }
        Map<Object, Integer> patternMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (!Objects.equals(patternMap.put(pattern.charAt(i), i), patternMap.put(strings[i], i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        WordPattern wordPattern = new WordPattern();
        String pattern = "abba";
        String str = "dog cat cat dog";
        System.out.println(wordPattern.wordPattern(pattern, str));
    }
}
