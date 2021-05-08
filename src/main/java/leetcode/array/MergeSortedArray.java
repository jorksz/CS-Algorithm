package leetcode.array;

import java.util.Arrays;

public class MergeSortedArray {

    /**
     * API
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        for (int i = 0; i < n; i++) {
            nums1[m - 1 + i] = nums2[i];
        }

        Arrays.sort(nums1);
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {

    }
}
