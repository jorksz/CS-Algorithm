package leetcode.array;

public class CoordinateWithMaximumNetworkQuality {

    public int[] bestCoordinate(int[][] towers, int radius) {
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        // 可以不用求最大值，因为
        // 1 <= towers.length <= 50
        // towers[i].length == 3
        // 0 <= xi, yi, qi <= 50
        // 1 <= radius <= 50
        for (int[] ints : towers) {
            maxX = Math.max(maxX, ints[0]);
            maxY = Math.max(maxY, ints[1]);
        }
        int cx = 0;
        int cy = 0;
        int best = 0;
        for (int i = 0; i <= maxX; i++) {
            for (int j = 0; j <= maxY; j++) {
                int[] coordinate = {i, j};
                int every = 0;
                for (int[] tower : towers) {
                    double euclideanMetric = getEuclideanMetric(tower, coordinate);
                    if (euclideanMetric <= radius) {
                        every += Math.floor(tower[2] / (1 + euclideanMetric));
                    }
                }

                if (every > best) {
                    best = every;
                    cx = i;
                    cy = j;
                }

            }
        }

        return new int[]{cx, cy};
    }

    private double getEuclideanMetric(int[] tower, int[] coordinate) {
        return Math.sqrt((tower[0] - coordinate[0]) * (tower[0] - coordinate[0]) + (tower[1] - coordinate[1]) * (tower[1] - coordinate[1]));
    }

    public static void main(String[] args) {

    }
}
