package leetcode.array;

import java.util.Arrays;
import java.util.Comparator;

public class HowManyNumbersAreSmallerThanTheCurrentNumber {
    // 暴力法很直接，直接双重循环遍历，统计即可
    // 这里利用一个二维数组来记录原来数字的位置，然后通过快排进行排序，最后根据
    // 数字原来的位置记录答案即可。
    public int[] smallerNumbersThanCurrent(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[][] sortNums = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            // 复制 nums 数组
            sortNums[i][0] = nums[i];
            // 原来的位置
            sortNums[i][1] = i;
        }
        Arrays.sort(sortNums, Comparator.comparingInt(o -> o[0]));
        int[] counts = new int[nums.length];
        for (int i = 1; i < sortNums.length; i++) {
            if (sortNums[i][0] == sortNums[i-1][0]) {
                counts[sortNums[i][1]] =  counts[sortNums[i-1][1]];
            }
            else {
                counts[sortNums[i][1]] = i;
            }
        }
        return counts;
    }

    public static void main(String[] args) {
        HowManyNumbersAreSmallerThanTheCurrentNumber t = new HowManyNumbersAreSmallerThanTheCurrentNumber();
        int[] nums = {6,5,4,8};
        for (int i : t.smallerNumbersThanCurrent(nums)) {
            System.out.print(i + " ");
        }
    }
}
