package leetcode.simulation;

public class ChampagneTower {

    /**
     * 模拟倒香槟的一个过程
     * 将全部香槟倒入第一个杯子中，如果满了（>1)就会往下流，往下流入的杯子为((X-1)/2),所以统计该值即可。
     * 每一层结束后将该值赋于rows，最终结果从rows取即可。
     * @param poured
     * @param query_row
     * @param query_glass
     * @return
     */
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] rows = {poured};

        for (int i = 1; i <= query_row; i++) {
            double[] nextRows = new double[i + 1];
            for (int j = 0; j < i; j++) {
                double volume = rows[j];
                if (volume > 1) {
                    double nextVolume = (volume - 1) / 2;
                    nextRows[j] += nextVolume;
                    nextRows[j + 1] += nextVolume;
                }
            }
            rows = nextRows;
        }

        return Math.min(1, rows[query_glass]);
    }

    public double champagneTowerDp(int poured, int query_row, int query_glass) {
        // 值限制，0 <= query_glass <= query_row < 100
        // 定义volumes[i][j]  为第 i 行第 j 列杯子所经过的水的流量（而不是最终剩余的水量）。
        double[][] volumes = new double[query_row + 10][query_row + 10];
        // 初始化边界
        volumes[0][0] = poured;
        for (int i = 0; i <= query_row; i++) {
            for (int j = 0; j <= i; j++) {
                if (volumes[i][j] > 1) {
                    double flowVolume = (volumes[i][j] - 1) /2;
                    // 统计第 i 行第 j 列杯子所经过的水的流量
                    volumes[i + 1][j] += flowVolume;
                    volumes[i + 1][j + 1] += flowVolume;
                }
            }
        }
        return Math.min(1, volumes[query_row][query_glass]);
    }

    public static void main(String[] args) {
        ChampagneTower champagneTower = new ChampagneTower();
        int poured = 2, query_glass = 1, query_row = 1;
        System.out.println(champagneTower.champagneTower(poured,query_row, query_glass));
    }
}
