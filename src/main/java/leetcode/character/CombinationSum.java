package leetcode.character;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(candidates, target, 0, new ArrayList<>());
        return res;
    }

    private void helper(int[] candidates, int target, int start, ArrayList<Integer> temp) {
        if (target < 0){
            return;
        }
        if (target == 0){
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < candidates.length; i++){
            if (target >= candidates[i]){
                temp.add(candidates[i]);
                helper(candidates, target - candidates[i], i, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int[] candidates = {2,5,2,1,2};
        int target = 5;
        System.out.println(combinationSum.combinationSum(candidates, target));
    }
}
