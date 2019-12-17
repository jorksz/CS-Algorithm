package leetcode.tree;

/**
 * 题目
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 */

public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode root, TreeNode root1) {
        if (root == null && root1 == null){
            return true;
        }

        if (root == null || root1 == null){
            return false;
        }

        return (root.val == root1.val) && isMirror(root.left,root1.right)
                && isMirror(root.right, root1.left);
    }
}

/**
 * 解题思路
 *
 * 递归，这里为了方便判断左右子树，新建一个方法
 * 如果左右子树为空，则为true
 * 如果左右子树有一个为空，则为false
 * 如果左右子树都不为空，判断值是否相等，然后递归左对右
 */