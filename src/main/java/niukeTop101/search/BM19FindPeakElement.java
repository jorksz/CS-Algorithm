package niukeTop101.search;

public class BM19FindPeakElement {

    public int findPeakElement (int[] nums) {
        // write code here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int[] res = new int[nums.length];

        for (int i = 1;i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                res[i] = 1;
            }
        }

        for (int i = nums.length - 2;i > 0; i--) {
            if (nums[i] > nums[i+1]) {
                res[i] = res[i] + 1;
            }
        }

        for (int i = 0; i < res.length;i++) {
            if (res[i] >= 2) {
                return i;
            }
        }
        return 0;
    }

    public int findPeakElement2 (int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        BM19FindPeakElement findPeakElement = new BM19FindPeakElement();
        System.out.println(findPeakElement.findPeakElement(nums));
    }
}
