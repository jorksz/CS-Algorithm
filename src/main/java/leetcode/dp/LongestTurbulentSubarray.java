package leetcode.dp;

/**
 * @author lijt
 */
public class LongestTurbulentSubarray {

    /**
     * @param arr
     * @return
     */
    public int maxTurbulenceSize(int[] arr) {
        if (arr.length < 2) {
            return arr.length;
        }
        int len = arr.length;
        // 定义两种状态，用来记录湍流子数组的长度
        // 上升状态 -> arr[i - 1] < arr[i]
        int[] ups = new int[len];
        // 下降状态 arr[i - 1] > arr[i]
        int[] downs = new int[len];
        //初始化边界
        ups[0] = 1;
        downs[0] = 1;
        int res = 0;
        for (int i = 1; i < len; i++) {
            // 上升
            if (arr[i - 1] < arr[i]) {
                ups[i] = downs[i - 1] + 1;
                downs[i] = 1;
            } else if (arr[i - 1] > arr[i]) {
                downs[i] = ups[i - 1] + 1;
                ups[i] = 1;
            } else {
                ups[i] = 1;
                downs[i] = 1;
            }

            res = Math.max(res, Math.max(downs[i], ups[i]));
        }
        return res;
    }
}
