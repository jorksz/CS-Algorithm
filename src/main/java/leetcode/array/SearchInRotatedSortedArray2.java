package leetcode.array;

/**
 * @author lijt
 */
public class SearchInRotatedSortedArray2 {
    public boolean search(int[] nums, int target) {
        for (int i : nums) {
            if (i == target) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray2 search = new SearchInRotatedSortedArray2();
        int[] nums = {2,5,6,0,0,1,2};
        int target = 0;
        System.out.println(search.search(nums, target));
    }
}

