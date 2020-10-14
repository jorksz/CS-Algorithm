package leetcode.array;

public class MagicIndexLCCI {
    public int findMagicIndex(int[] nums) {
        if (nums == null || nums.length == 0){
            return -1;
        }

        for (int i = 0; i < nums.length; i++){
            if (i == nums[i]){
                return i;
            }
        }
        return -1;
    }

    public int findMagicIndex2(int[] nums) {
        if (nums == null || nums.length == 0){
            return -1;
        }
        for (int i = 0; i < nums.length; i++){
            if (i == nums[i]){
                return i;
            }
            if (nums[i] > i){
                i = nums[i] - 1;
            }
        }
        return -1;

    }
}
