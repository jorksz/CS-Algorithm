package leetcode.array;


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

    public static void nextPermutation(int[] num) {
        if(num.length == 0 || num == null){
            return;
        }






        for( int k : num){
            System.out.print(k +" ");
        }
    }

    public static void main(String[] args) {
        int[] num = {1,2,3};
        nextPermutation(num);
    }
}
