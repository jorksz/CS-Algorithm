package leetcode.array;

import java.util.Arrays;

/**
 * 要使最高分和最低分差值最小，那么选中的这些数肯定是连着一起的，所以这边分两步走
 * 1、按升序进行排序
 * 2、对于这种在范围取最小或者最大的，可以利用一个滑动窗口机制，窗口容量就是 k, 左边就是 i,右边是 i+k-1,然后反复做比即可
 */
public class MinimumDifferenceBetweenHighestAndLowestOfKScores {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i + k - 1 < nums.length; i++) {
            res = Math.min(res, nums[i+k-1] - nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        MinimumDifferenceBetweenHighestAndLowestOfKScores m = new MinimumDifferenceBetweenHighestAndLowestOfKScores();
        int[] nums = {9,4,1,7};
        m.minimumDifference(nums, 3);
    }
}
