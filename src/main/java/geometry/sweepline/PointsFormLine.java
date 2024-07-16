package geometry.sweepline;

public class PointsFormLine {

    public boolean checkStraightLine(int[][] coordinates) {

        for (int i = 1; i < coordinates.length - 1; i++) {
            if (!calculateCrossProduct(coordinates[0], coordinates[i], coordinates[coordinates.length - 1])) {
                return false;
            }
        }
        return true;
    }

    private boolean calculateCrossProduct(int[] A, int[] B, int[] C) {
        return (B[0] - A[0]) * (C[1] - A[1]) - (C[0] - A[0]) * (B[1] - A[1]) == 0;
    }

    public static void main(String[] args) {
       // coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]];
        int[][] coordinates = new int[6][2];
        coordinates[0] = new int[]{1, 2};
        coordinates[1] = new int[]{2, 3};
        coordinates[2] = new int[]{3, 4};
        coordinates[3] = new int[]{4, 5};
        coordinates[4] = new int[]{5, 6};
        coordinates[5] = new int[]{6, 7};

        PointsFormLine pointsFormLine = new PointsFormLine();
        System.out.println(pointsFormLine.checkStraightLine(coordinates));
    }
}
