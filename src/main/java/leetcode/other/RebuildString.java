package leetcode.other;

import java.util.Comparator;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class RebuildString {
    public String reorganizeString(String S) {
        if (S.length() < 2) {
            return S;
        }
        int maxCount = 0;
        int[] chars = new int[26];
        for (int i = 0; i < S.length(); i++) {
            int index = S.charAt(i) - 'a';
            chars[index]++;
            maxCount = Math.max(maxCount, chars[index]);
        }

        if (maxCount > (S.length() + 1) / 2) {
            return "";
        }

        PriorityQueue<Character> priorityQueue = new PriorityQueue<>((o1, o2) -> chars[o2 - 'a'] - chars[o1 - 'a']);
        for (char c = 'a'; c <= 'z'; c++) {
            if (chars[c - 'a'] > 0) {
                priorityQueue.offer(c);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (priorityQueue.size() > 1){
            char c1 = priorityQueue.poll();
            char c2 = priorityQueue.poll();
            stringBuilder.append(c1);
            stringBuilder.append(c2);
            chars[c1 - 'a']--;
            chars[c2 - 'a']--;
            int count1 = chars[c1 - 'a'];
            int count2 = chars[c2 - 'a'];
            if (count1 > 0) {
                priorityQueue.offer(c1);
            }
            if (count2 > 0) {
                priorityQueue.offer(c2);
            }
        }

        if (priorityQueue.size() > 0) {
            stringBuilder.append(priorityQueue.poll());
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String s = "aab";
        RebuildString rebuildString = new RebuildString();
        System.out.println(rebuildString.reorganizeString(s));
    }
}
