package leetcode.array;

public class ValidMountainArray {
    /**
     * 统计上升的数量， 在统计下降的数量，最终数量 = 数组长度-1，就是有效的山脉数组
     * @param A
     * @return
     */
    public boolean validMountainArray(int[] A) {
        if (A.length < 3) {
            return false;
        }
        int i = 0;
        int len = A.length;
        while (i + 1 < len && A[i] < A[i + 1]) {
            i++;
        }
        if (i == 0 || i == len - 1) {
            return false;
        }
        while (i + 1 < len && A[i] > A[i+1]) {
            i++;
        }
        return i == len - 1;
    }

    public static void main(String[] args) {
        ValidMountainArray validMountainArray = new ValidMountainArray();
        int[] A = {0,3,2,1};
        int[] A2 = {3,5,5};
        System.out.println(validMountainArray.validMountainArray(A));
        System.out.println(validMountainArray.validMountainArray(A2));
    }
}
