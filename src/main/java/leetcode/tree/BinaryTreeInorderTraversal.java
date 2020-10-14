package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        helper(root);
        return res;
    }

    private void helper(TreeNode root) {
        if (root == null){
            return;
        }
        helper(root.left);
        res.add(root.val);
        helper(root.right);
    }
}

