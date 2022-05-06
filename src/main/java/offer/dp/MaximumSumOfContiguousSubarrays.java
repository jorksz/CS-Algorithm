package offer.dp;

/**
 * 剑指 Offer 42. 连续子数组的最大和
 */
public class MaximumSumOfContiguousSubarrays {

    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i-1], 0);
            res = Math.max(nums[i], res);
        }
        return res;
    }

    public static void main(String[] args) {
        MaximumSumOfContiguousSubarrays sum = new MaximumSumOfContiguousSubarrays();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(sum.maxSubArray(nums));
    }



}
