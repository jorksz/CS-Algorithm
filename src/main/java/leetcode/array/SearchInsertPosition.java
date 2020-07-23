package leetcode.array;

public class SearchInsertPosition {

    public static int  searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int res = nums.length;
        while (low <= high){
            int mid = (low + high) /2;
            if (nums[mid] >= target){
                res = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 0;
        System.out.println(searchInsert(nums, target));
    }
}
