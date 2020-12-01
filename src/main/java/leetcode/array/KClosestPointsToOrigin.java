package leetcode.array;

import java.util.*;

public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, Comparator.comparingInt(o -> (o[0] * o[0] + o[1] * o[1])));
        return Arrays.copyOfRange(points, 0, K);
    }

    public static void main(String[] args) {
        KClosestPointsToOrigin kClosestPointsToOrigin = new KClosestPointsToOrigin();
        int[][]points = {{0,1},{1,0}};
        int[][] res = kClosestPointsToOrigin.kClosest(points, 2);
        for (int[] ints : res) {
            for (int i : ints) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println(-1^2);
    }
}
