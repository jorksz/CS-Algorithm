package leetcode.array;


import java.util.Arrays;
import java.util.HashMap;

/**
 * 题目
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 */

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return nums;
        }

        HashMap<Integer, Integer> res = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            if(res.containsKey(target - nums[i])){
                return new int[] {res.get(target - nums[i]), i};
            }

            res.put(nums[i], i);
        }

        return new int[2];
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int target = 4;

        int[] res = twoSum(nums, target);
        for (int i : res){
            System.out.println(i);
        }
    }
}

/**
 *
 * 这里可以直接两个for循环就可以得出结果，这样复杂度就是O（n*n)了
 *
 * 另外一种解法，利用哈希来解决，在迭代插入值的过程中就可以进行判断当前元素是否为目标元素，
 * 是的话直接返回
 * 时间复杂度为O（n)
 * 空间为O（1）
 *
 */