package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    /**
     * 计算和
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        // 最少需要3个数，所以少于这个数量直接返回
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }

        // 既然要计算和，那么排个序会更好处理些
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // 当前index后边全是正数，是无法得到 0 的，所以直接返回
            if (nums[i] > 0) {
                return result;
            }

            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int current = nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int tempSum = current + nums[left] + nums[right];
                if (tempSum == 0) {
                    List<Integer> subResult = Arrays.asList(nums[left], current, nums[right]);
                    result.add(subResult);
                    // 之前没考虑处理重复值，导致结果会有重复集，一方面可以通过集合去做过滤，一方面可以直接在这让指针移动一位
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right-1]) {
                        right--;
                    }
                    left++;
                    right--;
                }
                else if (tempSum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.threeSum(nums));

        int[] nums2 = new int[]{0,0,0,0};
        System.out.println(threeSum.threeSum(nums2));
    }
}
