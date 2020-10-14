package leetcode.character;

import leetcode.list.ListNode;

import java.util.ArrayList;
import java.util.List;

public class IncreasingSubsequences {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        helper(nums, new ArrayList<>(), Integer.MIN_VALUE, 0);
        return res;
    }

    private void helper(int[] nums, List<Integer> temp, int last, int start){
        if (start == nums.length){
            if (temp.size() >= 2) {
                res.add(new ArrayList<>(temp));
            }
            return;
        }
        if (nums[start] >= last){
            temp.add(nums[start]);
            helper(nums, temp, nums[start], start + 1);
            temp.remove(temp.size() - 1);
        }
        if (nums[start] != last){
            helper(nums, temp, last, start + 1);
        }
    }

    public static void main(String[] args) {
        IncreasingSubsequences i = new IncreasingSubsequences();
        int[] nums = {4, 6, 7, 7};
        System.out.println(i.findSubsequences(nums));
    }
}
