package leetcode.character;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class RansomNote {
    /**
     * 有点问题，O（n)遍历实现还是不行，要O(N*N)
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || ransomNote.isEmpty()) {
            return true;
        }

        int ransomNoteIndex = 0;
        int magazineIndex = 0;
        int count = 0;
        List<Character> characters = new ArrayList<>();
        while (ransomNoteIndex < ransomNote.length() && magazineIndex < magazine.length()) {
            if (ransomNote.charAt(ransomNoteIndex) == magazine.charAt(magazineIndex)) {
                count++;
                ransomNoteIndex++;
            } else {
                characters.add(magazine.charAt(magazineIndex));
            }
            magazineIndex++;
        }

        count += Stream.of(ransomNote.toCharArray()).filter(characters::contains).count();
        return count == ransomNote.length();
    }

    /**
     * 哈希表实现
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct1(String ransomNote, String magazine) {
        if (ransomNote == null || ransomNote.isEmpty()) {
            return true;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (Character character : ransomNote.toCharArray()) {
            if (!map.containsKey(character)) {
                return false;
            }
            int count = map.getOrDefault(character, 0);
            if (count == 0) {
                return false;
            }
            if (count >= 1) {
                map.put(character, count - 1);
            }

        }
        return true;
    }

    /**
     * 也是利用哈希表，但是通过字典数组实现的
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct2(String ransomNote, String magazine) {
        if (ransomNote == null || ransomNote.isEmpty()) {
            return true;
        }
        int[] chars = new int[26];
        for (Character character : magazine.toCharArray()) {
            chars[character - 'a'] ++;
        }

        for (Character character : ransomNote.toCharArray()) {
            if (--chars[character - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        RansomNote ransomNote = new RansomNote();
        String ransomNoteStr = "a";
        String magazine = "b";
        System.out.println(ransomNote.canConstruct2(ransomNoteStr, magazine));

        String ransomNoteStr1 = "aa";
        String magazine1 = "aab";
        System.out.println(ransomNote.canConstruct2(ransomNoteStr1, magazine1));

        String ransomNoteStr2 = "aa";
        String magazine2 = "ab";
        System.out.println(ransomNote.canConstruct2(ransomNoteStr2, magazine2));

        String ransomNoteStr3 = "aab";
        String magazine3 = "baa";
        System.out.println(ransomNote.canConstruct2(ransomNoteStr3, magazine3));
    }
}
