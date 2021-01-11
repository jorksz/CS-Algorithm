package leetcode.dp;

public class LCOF {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            sum = Math.max(sum, nums[i]);
        }
        return sum;
    }

    public static void main(String[] args) {
        LCOF lcof = new LCOF();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(lcof.maxSubArray(nums));
    }
}
