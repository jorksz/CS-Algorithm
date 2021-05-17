package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> root1Values = new ArrayList<>();
        helper(root1, root1Values);
        List<Integer> root2Values = new ArrayList<>();
        helper(root2, root2Values);
        return root1Values.equals(root2Values);
    }

    private void helper(TreeNode root1, List<Integer> values) {
        if (root1.left == null && root1.right == null) {
            values.add(root1.val);
        } else {
            if (root1.left != null) {
                helper(root1.left, values);
            }
            if (root1.right != null) {
                helper(root1.right, values);
            }
        }
    }
}
