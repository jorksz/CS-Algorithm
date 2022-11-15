package niukeTop101.str;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BM92 {

    /**
     * 要求：
     * 去重，子数组里边不能又重复数字
     * 连续，保持在原数组中的位置
     * @param arr
     * @return
     */
    public int maxLength (int[] arr) {
        // write code here
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for (int j : arr) {
            while (queue.contains(j)) {
                queue.poll();
            }
            queue.add(j);
            count = Math.max(count, queue.size());
        }

        return count;
    }

    public static void main(String[] args) {
        BM92 bm92 = new BM92();
        int[] arr = {2,3,4,5};
        System.out.println(bm92.maxLength(arr));

        int[] arr2 = {2,2,3,4,8,99,3};
        System.out.println(bm92.maxLength(arr2));
    }
}
