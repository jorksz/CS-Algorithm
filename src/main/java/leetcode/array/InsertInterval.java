package leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        // 是否替换过
        boolean replaced = false;
        List<int[]> ans = new ArrayList<>();
        for (int[] ints : intervals) {
            // 当前区间在要插入区间的右边
            if (ints[0] > right) {
                if (!replaced) {
                    ans.add(new int[]{left,right});
                    replaced = true;
                }
                ans.add(ints);
            }
            // 当前区间在要插入区间的左边
            else if (ints[1] < left) {
               ans.add(ints);
            }
            // 存在交集，合并
            else {
                left = Math.min(ints[0], left);
                right = Math.max(ints[1], right);
            }
        }
        // 如果没有符合区间大于要插入区间
        if (!replaced) {
            ans.add(new int[]{left, right});
        }

        int[][] res = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        InsertInterval insertInterval = new InsertInterval();
        int[][] intervals = {{1,3}, {6,9}};
        int[] ints = {2,5};
        insertInterval.insert(intervals, ints);
    }
}
