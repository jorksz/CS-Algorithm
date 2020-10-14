package leetcode.character;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        helper(k, n, 0, new ArrayList<Integer>(), nums);
        return res;
    }

    private void helper(int k, int n, int start, ArrayList<Integer> temp, int[] nums) {
        if (n == 0 && k == 0){
            res.add(new ArrayList<>(temp));
        }
        else {
            for (int i = start; i < nums.length; i++) {
                if (nums[i] <= n && k > 0 ) {
                    temp.add(nums[i]);
                    helper(k - 1, n - nums[i], i + 1, temp, nums);
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum3 combinationSum3 = new CombinationSum3();
        System.out.println(combinationSum3.combinationSum3(3, 7));
    }
}
