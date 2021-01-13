package leetcode.dp;

public class RangeSumQueryImmutable {
    private int[] nums;
    public RangeSumQueryImmutable(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        if (nums == null ||nums.length == 0) {
            return 0;
        }

        int sum = 0;
        if (i >= 0 && j < nums.length) {
            for (int k = i; k <= j; k++) {
                sum += nums[k];
            }
        }
        return sum;
    }
}
