package geometry.sweepline;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.*;

/**
 * 矩形面积2， https://leetcode.cn/problems/rectangle-area-ii/description/
 * 比较常见的利用扫描线来计算面积
 *
 * 竖着扫描，用区间Y的高度来作为扫描线，通过计算每个相邻的X差值*区间Y高度差，来收集面积结果
 * 中间状态就是：
 * 维护Y的区间高度，如果比上一个区间高就更新 Y的区间值
 * 同时也维护一个Y区间高度的差值
 *
 * 需要注意精度值。。。 用 int 收集结果会超出
 */
public class RectangleAreaII {

    public int rectangleArea(int[][] rectangles) {
        // 降维，收集X坐标，并根据从小到大排序
        List<Integer> xList = new ArrayList<>();
        for (int[] rectangle : rectangles) {
            xList.add(rectangle[0]);
            xList.add(rectangle[2]);
        }

        Collections.sort(xList);
        int MOD = (int) (1.0E9 + 7);

        int res = 0;
        for (int i = 1; i < xList.size(); i++) {
            int xLeft = xList.get(i - 1);
            int xRight = xList.get(i);
            int interval = xRight - xLeft;
            if (interval == 0) {
                continue;
            }
            List<int[]> yList = new ArrayList<>();
            for (int[] rectangle : rectangles) {
                // 搞错了，这rectangle[2] 要大于 XRight 才记录，表示当前矩形区域覆盖 【xLeft，xRight】 这区域，最差也要是当前区域覆盖自己，所以有个=
                if (rectangle[0] <= xLeft && rectangle[2] >= xRight) {
                    yList.add(new int[]{rectangle[1], rectangle[3]});
                }
            }
            yList.sort((o1, o2) -> o1 != o2 ? o1[0] - o2[0] : o1[1] - o2[1]);
            long yTotal = 0;
            int lastDownY = -1;
            int lastUpY = -1;
            for (int[] ys : yList) {
                // 如果当前最低的高度都高于上次最高高度，那么更新全部信息
                if (ys[0] > lastUpY) {
                    // 先计算高度差值再赋值
                    yTotal += lastUpY - lastDownY;
                    lastDownY = ys[0];
                    lastUpY = ys[1];
                } else if (ys[1] > lastUpY){
                    // 只是当前最高高于上次最高
                    lastUpY = ys[1];
                }
            }
            yTotal += lastUpY - lastDownY;
            long value = yTotal * interval;
            res += value;
            res = res % MOD;
        }
        return res;
    }

    public static void main(String[] args) {
        List<int[]> rectangles = new ArrayList<>();
        rectangles.add(new int[]{0,0,2,2});
        rectangles.add(new int[]{1,0,2,3});
        rectangles.add(new int[]{1,0,3,1});
        RectangleAreaII rectangleAreaII = new RectangleAreaII();
        System.out.println("res:" + rectangleAreaII.rectangleArea(rectangles.toArray(new int[][]{})));
    }
}
