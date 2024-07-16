package geometry.sweepline;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 天际线 @link https://leetcode.cn/problems/the-skyline-problem/
 */
public class TheSkylineProblem {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        // 降维，
        List<int[]> buildingList = new ArrayList<>();
        for (int[] building : buildings) {
            int[] leftBuild = new int[2];
            leftBuild[0] = building[0];
            // 左边界设置成负值，方便判断，下边计算需要转成正值
            leftBuild[1] = -building[2];
            buildingList.add(leftBuild);
            int[] rightBuild = new int[2];
            rightBuild[0] = building[1];
            rightBuild[1] = building[2];
            buildingList.add(rightBuild);
        }
        // 排个序，按X从小到大排，如果X相同，则比较高度，也是从小到大
        buildingList.sort((o1, o2) -> {
            if (o1[0] - o2[0] == 0) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });

        List<List<Integer>> res = new ArrayList<>();
        // 最大堆，记录高度状态
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        int maxHeight = 0;
        // 结果必定是有个0值的
        priorityQueue.add(maxHeight);

        for (int[] build : buildingList) {
            // 左边界那么将这个高度入队，右边界删除即可
            if (build[1] < 0) {
                priorityQueue.add(-build[1]);
            } else {
                priorityQueue.remove(build[1]);
            }
            // 与当前最高度不同，则收集结果
            if (!priorityQueue.isEmpty() && maxHeight != priorityQueue.peek()) {
                maxHeight = priorityQueue.peek();
                List<Integer> tempList = new ArrayList<>();
                tempList.add(build[0]);
                tempList.add(maxHeight);
                res.add(tempList);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int COUNT_BITS = Integer.SIZE - 3;
        System.out.println(COUNT_BITS);
    }
}
