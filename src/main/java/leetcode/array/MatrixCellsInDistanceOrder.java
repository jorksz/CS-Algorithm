package leetcode.array;

import java.util.Arrays;
import java.util.Comparator;

public class MatrixCellsInDistanceOrder {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] ints = new int[R * C][2];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                ints[i * C + j] = new int[]{i,j};
            }
        }
        Arrays.sort(ints, Comparator.comparingInt(o -> (Math.abs(o[0] - r0) + Math.abs(o[1] - c0))));
        return ints;
    }

    public static void main(String[] args) {
        MatrixCellsInDistanceOrder matrixCellsInDistanceOrder = new MatrixCellsInDistanceOrder();
        matrixCellsInDistanceOrder.allCellsDistOrder(3,3,2,2);
    }
}
