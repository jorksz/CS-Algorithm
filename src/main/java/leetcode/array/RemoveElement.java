package leetcode.array;

/**
 * 题目
 *
 * 给定一个数组和一个值，使用就地算法将数组中所有等于这个值的元素删除，并返回新数组的长度。
 * 元素的顺序可以更改。你不用去关心大于当前数组长度的空间里面存储的值
 *
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class RemoveElement {
    public static int removeElement(int[] A, int elem) {
        if(A == null || A.length  == 0){
            return 0;
        }

        int len = A.length - 1;
        for(int i = 0; i <= len; i++){
            if(A[i] == elem){
                A[i--] = A[len--];
            }
        }

        return len+1;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,4};
        System.out.println(removeElement(A,1));
    }
}


/**
 *解题思路
 *
 * 扫描数组，当与目标数字相同的时候，从后面调一个数字进行替换
 */