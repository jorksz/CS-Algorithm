package leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class IslandPerimeter {
    /**
     * 找到数字1，1.看看是否为边界 2.周围是否为0
     * 因为左右最终总是成对出现，上下也是，所以这里只需要查找左，上即可。
     */
    public int islandPerimeter(int[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    if (i == 0 || grid[i-1][j] == 0) {
                        sum += 2;
                    }

                    if (j == 0 || grid[i][j-1] == 0) {
                        sum += 2;
                    }
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] nums = {{0,1,0,0}, {1,1,1,0}, {0,1,0,0}, {1,1,0,0}};
        IslandPerimeter islandPerimeter = new IslandPerimeter();
        System.out.println(islandPerimeter.islandPerimeter(nums));
    }
}

