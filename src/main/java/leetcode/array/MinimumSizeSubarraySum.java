package leetcode.array;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }

        int start = 0;
        int end = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;

        while (end < nums.length){
            sum = sum + nums[end];
            while (sum >= s){
                res = Math.min(res, end - start + 1);
                sum = sum - nums[start];
                start++;
            }
            end++;
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
