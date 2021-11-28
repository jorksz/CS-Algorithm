package leetcode.array;

public class SumOfAllOddLengthSubarrays {

    /**
     * 求数组的子数组奇数和，len1, len3, len5 ...
     *
     * 三层遍历。。
     * 前缀和 get!
     * @param arr
     * @return
     */
    public int sumOddLengthSubarrays(int[] arr) {
        int len = arr.length;
        int[] sum = new int[len + 1];
        sum[0] = arr[0];
        // 计算前缀和
        for (int i = 1 ; i < len; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }

        int left = 0;
        int right;
        int res = 0;
        while (left < len) {
            right = left;
            while (right < len) {
                int index = right - left + 1;
                if (index % 2 == 1) {
                    res += sum[right] - sum[left] + arr[left];
                }
                right ++;
            }
            left ++;
        }

        return res;
    }

    public static void main(String[] args) {
        SumOfAllOddLengthSubarrays sumOfAllOddLengthSubarrays = new SumOfAllOddLengthSubarrays();
        int [] arr = {1,2,3};
        System.out.println(sumOfAllOddLengthSubarrays.sumOddLengthSubarrays(arr));
    }
}
