package leetcode.character;


import java.util.HashSet;

/**
 * 题目
 *
 * 给定一个字符串，找出最长的不具有重复字符的子串的长度。
 * 例如，“abcabcbb”不具有重复字符的最长子串是“abc”，长度为3。
 * 对于“bbbbb”，最长的不具有重复字符的子串是“b”，长度为1。
 */

public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        HashSet<Character> res = new HashSet<>();

        int max = 0;
        int pre = 0;
        int rear = 0;

        while (rear  < s.length()){

            if(res.contains(s.charAt(rear))){
                if(max < rear - pre) {
                    max = rear - pre;
                }
                while (s.charAt(pre) != s.charAt(rear)){
                    res.remove(s.charAt(pre));
                    pre ++;
                }
                pre++;
            }

            else {
                res.add(s.charAt(rear));
            }
            rear++;
        }

        max = Math.max(max, rear - pre);

        return max;

    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}

/**
 * 基本思路是维护一个窗口，每次关注窗口中的字符串，在每次判断中，左窗口和右窗口选择其一向前移动。
 * 同样是维护一个HashSet, 正常情况下移动右窗口，如果没有出现重复则继续移动右窗口，
 * 如果发现重复字符，则说明当前窗口中的串已经不满足要求，继续移动右窗口不可能得到更好的结果，
 * 此时移动左窗口，直到不再有重复字符为止，中间跳过的这些串中不会有更好的结果
 * 因为他们不是重复就是更短。因为左窗口和右窗口都只向前，所以两个窗口都对每个元素访问不超过一遍
 * 因此时间复杂度为O(2*n)=O(n),是线性算法。空间复杂度为HashSet的size,也是O(n).
 * ————————————————
 * 原文链接：https://blog.csdn.net/linhuanmars/article/details/19949159
 */