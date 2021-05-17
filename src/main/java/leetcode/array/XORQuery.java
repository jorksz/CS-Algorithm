package leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class XORQuery {
    public int[] xorQueries(int[] arr, int[][] queries) {
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            int first = queries[i][0];
            int last = queries[i][1];
            int tempRes = arr[first];
            for (int j = first + 1; j <= last; j++) {
                tempRes ^= arr[j];
            }
            arrayList.add(tempRes);
        }
        int[] res = new int[arrayList.size()];
        for (int i = 0; i < res.length; i++) {
            System.out.println(arrayList.get(i));
            res[i] = arrayList.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,4,8};
        int[][] queries = new int[][]{{0,1},{1,2},{0,3},{3,3}};
        XORQuery xorQuery = new XORQuery();
        xorQuery.xorQueries(arr, queries);
    }
}
