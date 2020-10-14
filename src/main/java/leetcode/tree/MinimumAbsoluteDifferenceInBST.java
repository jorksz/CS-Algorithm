package leetcode.tree;

import java.util.ArrayList;

public class MinimumAbsoluteDifferenceInBST {
    ArrayList<Integer> res = new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
        helper(root);
        int minN = Integer.MAX_VALUE;
        if (res.size() > 1) {
            for (int i = 1; i < res.size(); i++) {
                minN = Math.min(minN, res.get(i) - res.get(i - 1));
            }
        }
        return minN;
    }

    private void helper(TreeNode root) {
        if (root == null){
            return;
        }
        helper(root.left);
        res.add(root.val);
        helper(root.right);
    }


    //在递归中获取目前最小值，递归结束当前值即为最小值
    int resN = Integer.MAX_VALUE;
    int pre = -1;
    public int getMinimumDifference2(TreeNode root) {
        if (root == null){
            return pre;
        }
        dfs(root);
        return resN;
    }

    private void dfs(TreeNode root) {
       if (root == null) {
           return;
       }
       dfs(root.left);
       if (pre == -1) {
           pre = root.val;
       }
       else {
           resN = Math.min(resN, root.val - pre);
           pre = root.val;
       }
       dfs(root.right);
    }

}
