package leetcode.character;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        helper(n, k,1, new ArrayList<>());
        return res;
    }

    private void helper(int n, int k, int start, ArrayList<Integer> objects) {
        if (objects.size() == k){
            res.add(new ArrayList<>(objects));
            return;
        }
        for (int i = start; i <= n; i++){
            objects.add(i);
            helper(n, k, i + 1, objects);
            objects.remove(objects.size() - 1);
        }
    }
}
