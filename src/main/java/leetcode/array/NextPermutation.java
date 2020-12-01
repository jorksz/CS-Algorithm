package leetcode.array;


import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 实现函数next permutation（下一个排列）：
 * 将排列中的数字重新排列成字典序中的下一个更大的排列。
 * 如果不存在这样的排列，则将其排列为字典序最小的排列（升序排列）
 * 需要使用原地算法来解决这个问题，不能申请额外的内存空间
 * 下面有机组样例，左边是输入的数据，右边是输出的答案
 * 1,2,3→1,3,2
 * 3,2,1→1,2,3
 * 1,1,5→1,5,1
 */
public class NextPermutation {

    /**
     * 读个题都要读半小时，太难了。。
     * 从后往前找，找到比较小的那个
     * 然后再次从后往前找，找到比第一次还要大的数，交换位置
     * 然后把第一次数后面的进行从小到大排序即可，保证尽可能的不是很大。
     * 如果开始就是最大数列，直接逆序即可。
     * @param num
     */
    public void nextPermutation(int[] num) {
        if(num.length == 0){
            return;
        }
        int index = num.length - 2;
        while (index >= 0 && num[index] >= num[index + 1]) {
            index --;
        }

        if (index >= 0) {
            int j = num.length - 1;
            while (j > 0 && num[j] <= num[index]) {
                j--;
            }
            swap(num, index, j);
        }
        sorts(num, index + 1);
    }

    private  void sorts(int[] num, int index) {
        int len = num.length - 1;
        while (index < len) {
           swap(num, index, len);
           index ++;
           len --;
        }
    }

    private void swap(int[] num, int index, int j) {
        int temp = num[index];
        num[index] = num[j];
        num[j] = temp;
    }

    public static void main(String[] args) {
        int[] num = {1,5,1};
        NextPermutation nextPermutation = new NextPermutation();
        nextPermutation.nextPermutation(num);
        for (int i : num) {
            System.out.println(i);
        }
    }
}
