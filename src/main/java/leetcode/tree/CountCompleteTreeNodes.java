package leetcode.tree;

public class CountCompleteTreeNodes {
    int count = 0;
    public int countNodes(TreeNode root) {
        helper(root);
        return count;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root != null) {
            count++;
        }
        helper(root.left);
        helper(root.right);
    }
}
