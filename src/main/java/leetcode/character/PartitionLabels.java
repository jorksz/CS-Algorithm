package leetcode.character;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    // 这里刚好可以利用数组map来存储每个字符最后出现的位置
    // 根据题目要求，要把这个字符串划分为尽可能多的片段， 利用贪心算法的特性
    // 每一段都取近可能的最小结束下标，那么每段符合要求且最小，最终达到符合要求且最多的片段。
    // 这里可以使用前后指针来跟踪每段开始和结束的位置index
    // 遍历该字符串，获取每个字符最后出现的位置，保证每段包括这个字符
    // 如果当前遍历的index = 结束位置的index ，表示该段划分结束，即把该段的长度（last - pre + 1)加入到集合中
    // 同时初始化新片段开始的位置 last + 1， 从而又开始另外一个轮回。。。
    public List<Integer> partitionLabels(String S) {
        if (S == null || S.length() == 0) {
            return new ArrayList<>();
        }
        int[] ans = new int[26];
        for (int i = 0; i < S.length(); i++) {
            ans[S.charAt(i) - 'a'] = i;
        }
        List<Integer> res = new ArrayList<>();
        int front = 0;
        int last = 0;
        for (int i = 0; i < S.length(); i++) {
            // 获取每个字符最后出现的位置
            int tempLast = ans[S.charAt(i) - 'a'];
            // 保证一个字段包括该字母出现的最后位置的字符
            last = Math.max(last, tempLast);
            // 如果当前index = last， 表示这段已经结束，就把这段的长度添加到集合中，同时初始化下一段
            // 的开始位置，即为 结束位置 + 1
            if (i == last) {
                res.add(last - front + 1);
                front = last + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String S = "ababcbacadefegdehijhklij";
        PartitionLabels partitionLabels = new PartitionLabels();
        System.out.println(partitionLabels.partitionLabels(S));
    }
}
