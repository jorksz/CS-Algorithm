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

    public  static int removeElement2(int[] nums, int val) {
        if(nums == null ||nums.length == 0){
            return 0;
        }

        int i = 0;
        for (int j = 0; j < nums.length; j++){
            if (nums[j] != val){
                nums[i++] = nums[j];
            }
        }

        return i;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3};
        System.out.println(removeElement2(A,1));
    }
}


/**
 *解题思路
 *
 * 都是使用双指针来解决问题
 * 第一种解决方式扫描数组，当与目标数字相同的时候，从后面调一个数字进行替换
 *
 * 第二中是从前面开始遍历，当数字相同的时候，用后面的数字覆盖掉target，但是这里返回的位置index并不需要+1，
 * 上面那个解放从末尾需要+1
 */