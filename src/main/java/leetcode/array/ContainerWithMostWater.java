package leetcode.array;

/**
 * 给定n个非负整数a1，a2，…，an，其中每个数字表示坐标(i, ai)处的一个点。
 * 以（i，ai）和（i，0）（i=1,2,3...n）为端点画出n条直线。
 * 你可以从中选择两条线与x轴一起构成一个容器，最大的容器能装多少水？
 * 注意：你不能倾斜容器
 *
 * 例如：
 * 输入 [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 */

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }

        int left = 0;
        int right = height.length - 1;

        int maxArea = 0;

        while(left < right){
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            if(height[left] < height[right]){
                left ++;
            }
            else {
                right --;
            }

        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}


/**
 *
 * 解题思路
 *
 * 思路有点类似于Two Sum中的第二种方法--夹逼
 * 。从数组两端走起，每次迭代时判断左pointer和右pointer指向的数字哪个大，
 * 如果左pointer小，意味着向左移动右pointer不可能使结果变得更好，
 * 因为瓶颈在左pointer，移动右pointer只会变小，所以这时候我们选择左pointer右移。
 * 反之，则选择右pointer左移。在这个过程中一直维护最大的那个容积
 */