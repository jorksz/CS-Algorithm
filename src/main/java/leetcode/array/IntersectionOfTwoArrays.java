package leetcode.array;

import java.util.*;

public class IntersectionOfTwoArrays {
    // 排序+双指针遍历即可
    // 优化方案 直接将nums1 加入set， 遍历num2,
    // 如果set 包含 num[i] set2添加该元素，最后set2转为int[]即可
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        int countNum1 = 0;
        int countNum2 = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while (countNum1 < nums1.length && countNum2 < nums2.length) {
            if (nums1[countNum1] == nums2[countNum2]) {
                set.add(nums1[countNum1]);
                countNum1++;
                countNum2++;
            }
            else if (nums1[countNum1] < nums2[countNum2]) {
                countNum1++;
            }
            else {
                countNum2++;
            }
        }
        int[] ints = new int[set.size()];
        for (int i = 0; i < set.size(); i++) {
            ints[i] = (int) set.toArray()[i];
        }
        return ints;
    }

    public static void main(String[] args) {
        IntersectionOfTwoArrays intersectionOfTwoArrays = new IntersectionOfTwoArrays();
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] ints = intersectionOfTwoArrays.intersection(nums1, nums2);

    }
}
