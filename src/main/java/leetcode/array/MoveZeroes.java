package leetcode.array;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, i ,j);
                j++;
            }

        }
    }

    private void swap(int[] nums, int low, int high) {
        int temp = nums[low];
        nums[low] = nums[high];
        nums[high] = temp;
    }

    private void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int partition = getPartition(nums, low, high);
            quickSort(nums, low, partition);
            quickSort(nums, partition + 1, high);
        }
    }

    private int getPartition(int[] nums, int low, int high) {
        int mid = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= mid) {
                high--;
            }
            swap(nums, low, high);
            while (low < high && nums[low] <= mid) {
                low++;
            }
            swap(nums, low, high);
        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        MoveZeroes moveZeroes = new MoveZeroes();
        moveZeroes.moveZeroes(nums);
    }
}
