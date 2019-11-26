package leetcode.array;


/**
 * 题目
 *
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 */

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums == null ||nums.length == 0){
            return 0;
        }

        int len = 0;
        for (int i = 1; i < nums.length; i++){

            if (nums[len] != nums[i]){
                len++;
                nums[len] = nums[i];
            }
        }
        return len + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();
        int[] nums = {1,2,2,3};
        System.out.println(removeDuplicatesFromSortedArray.removeDuplicates(nums));
    }
}

/**
 *解题思路
 *
 * 双指针法，当前后相等的时候，跳过重复的值，也就是i往后面走，len不动。有点像把重复的值往后面推，不重复的值放在前面。
 * 这里的删除并不是真的删除，所以返回长度需要注意下。
 * 时间复杂度：O(n)。
 * 空间复杂度：O(1)。
 */