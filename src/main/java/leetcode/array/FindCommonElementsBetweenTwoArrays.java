package leetcode.array;

import java.util.HashSet;
import java.util.Set;

public class FindCommonElementsBetweenTwoArrays {

    /**
     * 才读懂题目，，
     * value1 求的是num1 数字在 num2出现的次数，包含重复
     * value2 求的是num2 数字在 num1出现的次数，包含重复
     * 用个 Hash 对两个num做个映射，然后相互计数即可。
     */
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {

        Set<Integer> num1Set = new HashSet<>();
        Set<Integer> num2Set = new HashSet<>();

        for (int num : nums1) {
            num1Set.add(num);
        }

        for (int num : nums2) {
            num2Set.add(num);
        }

        int num1Count = 0;
        for (int num : nums2) {
            if (num1Set.contains(num)) {
                num1Count ++;
            }
        }

        int num2Count = 0;
        for (int num : nums1) {
            if (num2Set.contains(num)) {
                num2Count ++;
            }
        }

        return new int[] {num2Count, num1Count};
    }

    public static void main(String[] args) {
        int[] nums1 = {2,3,2};
        int[] nums2 = {1,2};
        FindCommonElementsBetweenTwoArrays commonElementsBetweenTwoArrays = new FindCommonElementsBetweenTwoArrays();
        commonElementsBetweenTwoArrays.findIntersectionValues(nums1, nums2);
        int[] result = commonElementsBetweenTwoArrays.findIntersectionValues(nums1, nums2);
        System.out.println(result[0] + "-" + result[1]);
    }
}
