package leetcode.array;

import java.util.*;

public class TheNextLargerElements4 {
    public int[] secondGreaterElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        // 单调栈，元素顶到底大小为->小到大，存储nums[i]
        Deque<Integer> stack = new ArrayDeque<Integer>();
        // 存储已经找到它下一个比它大的数字的数组元素 num[2] = {ele, index}
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        for (int i = 0; i < nums.length; i++) {
            while (!priorityQueue.isEmpty() && priorityQueue.peek()[0] < nums[i]) {
                result[priorityQueue.poll()[1]] = nums[i];
            }
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                priorityQueue.add(new int[]{nums[stack.peek()], stack.peek()});
                stack.poll();
            }

            stack.push(i);
        }
        return result;
    }
}
