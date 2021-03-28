package leetcode.array;

import java.util.Arrays;

/**
 * 数组拆分 I
 * 题目要求每次在两个数之间取最小值来组成总和最大
 * 那么每次近可能的选择两数之间波动值较小的，也就是相差数最少的，这样获取每次最小总和即为最大值了
 * 在这之间进行一波排序，取 i%2=0 (i从0开始)即可。
 */
public class ArrayPartitionI {
    public int arrayPairSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int maxSum = 0;
        for (int i = 0; i < nums.length; i+=2) {
            maxSum += nums[i];
        }

        return maxSum;
    }

    public static void main(String[] args) {
        ArrayPartitionI arrayPartitionI = new ArrayPartitionI();
        int[] nums = {1,4,3,2};
        System.out.println(arrayPartitionI.arrayPairSum(nums));
    }
}
