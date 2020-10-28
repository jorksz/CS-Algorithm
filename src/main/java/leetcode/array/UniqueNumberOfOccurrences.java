package leetcode.array;

import java.util.*;

public class UniqueNumberOfOccurrences {
    // Hash + 数组记录出现的次数，给数组排序， 遍历前后有相同的就返回false
    public boolean uniqueOccurrences(int[] arr) {
        if (arr == null || arr.length == 0) {
            return true;
        }
        Arrays.sort(arr);
        Map<Integer, Integer> countNumMap = new HashMap<>();
        int [] counts = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (countNumMap.containsKey(arr[i])) {
                countNumMap.put(arr[i], countNumMap.get(arr[i]) + 1);
                counts[countNumMap.size() - 1] = countNumMap.get(arr[i]);
            }
            else {
                countNumMap.put(arr[i], 1);
                counts[countNumMap.size() -1] = 1;
            }
        }

        Arrays.sort(counts);
        for (int i = 1; i < counts.length; i++) {
            if (counts[i] == counts[i-1] && counts[i] != 0){
                return false;
            }
        }
        return true;
    }

    // hash + set ，比较两个size大小，相同返回true
    public boolean uniqueOccurrences2(int[] arr) {
        Map<Integer, Integer> countNumMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            countNumMap.put(arr[i], countNumMap.getOrDefault(arr[i], 0) + 1);
        }
        Set<Integer> set = new HashSet<>();
        countNumMap.forEach((k, v) ->set.add(v));
        return set.size() == countNumMap.size();
    }

    public static void main(String[] args) {
        UniqueNumberOfOccurrences uniqueNumberOfOccurrences = new UniqueNumberOfOccurrences();
        int[] ints = {1,2,2,1,1,3};
        System.out.println(uniqueNumberOfOccurrences.uniqueOccurrences(ints));
        int[] ints1 = {1,2};
        System.out.println(uniqueNumberOfOccurrences.uniqueOccurrences(ints1));
        int[] ints2 = {-3,0,1,-3,1,1,1,-3,10,0};
        System.out.println(uniqueNumberOfOccurrences.uniqueOccurrences(ints2));
    }
}
