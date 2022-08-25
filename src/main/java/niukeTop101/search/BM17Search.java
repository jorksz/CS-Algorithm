package niukeTop101.search;

import java.util.Arrays;

public class BM17Search {

    public int search (int[] nums, int target) {
        // write code here
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left  = 0;
        int len = nums.length;
        int right = len;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left++;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        BM17Search bm17Search = new BM17Search();
        int[] nums = {0,1};
        int target = 1;
        System.out.println(bm17Search.search(nums, target));
    }
}
