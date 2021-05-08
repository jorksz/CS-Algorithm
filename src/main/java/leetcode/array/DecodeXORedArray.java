package leetcode.array;

import java.util.Arrays;

public class DecodeXORedArray {

    /**
     * 解题思路：
     * 原理: a^b = c 那么 c^b = a 和 c^a = b
     */
    public int[] decode(int[] encoded, int first) {
        if (encoded == null || encoded.length == 0) {
            return new int[0];
        }

        int len = encoded.length;
        int[] arrays = new int[len + 1];
        arrays[0] = first;
        for (int i = 0; i < len; i++) {
            arrays[i + 1] = arrays[i] ^ encoded[i];
        }
        return arrays;
    }

    public static void main(String[] args) {
        DecodeXORedArray decodeXORedArray = new DecodeXORedArray();
        int[] encoded = new int[]{1,2,3};
        int first = 1;
        int[] arrays = decodeXORedArray.decode(encoded, first);
        Arrays.stream(arrays).forEach(System.out::println);
    }
}
