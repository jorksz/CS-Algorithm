package leetcode.array;

import java.util.*;

public class IntersectionOfTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums2.length > nums1.length){
            return intersect(nums2, nums1);
        }

        Map<Integer, Integer> res = new HashMap<>();
        for (int i = 0; i < nums1.length; i++){
            int count =res.getOrDefault(nums1[i], 0) + 1;
            res.put(nums1[i], count);
        }

        int index = 0;
        int[] ints = new int[nums1.length];
        for (int j = 0; j < nums2.length; j ++){
            int count = res.getOrDefault(nums2[j], 0);
            if (count-- > 0){
                ints[index++] = nums2[j];
                if (count > 0){
                    res.put(nums2[j], count);
                }
                else {
                    res.remove(nums2[j]);
                }
            }
        }
        return Arrays.copyOfRange(ints, 0 , index);
    }
}
