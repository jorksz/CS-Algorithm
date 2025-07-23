package leetcode.tree;

public class ReverseOddLevelsOfBinaryTree {

    /**
     * 完美二叉树
     * 一个根节点必有左右两个节点
     * @param root
     * @return
     */
    public TreeNode reverseOddLevels(TreeNode root) {
        dfs(root.left, root.right, true);
        return root;
    }

    private void dfs(TreeNode left, TreeNode right, boolean isOdd) {
        //完美二叉树一个根节点必有左右两个节点,左没有就结束了
        if (left == null) {
            return;
        }

        // 偶次数的子节点是奇节点
        if (isOdd) {
            int temp = right.val;
            right.val = left.val;
            left.val = temp;
        }

        dfs(left.left, right.right, !isOdd);
        dfs(left.right, right.left, !isOdd);
    }
}
