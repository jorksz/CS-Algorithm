package leetcode.dp;

import leetcode.dp.TreeNode;

/**
 * 二叉树的直径
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/
 */
public class DiameterofBinaryTree {
    int res;
    public int diameterOfBinaryTree(TreeNode root) {
        res = 1;
        getPath(root);
        return res - 1;
    }

    int getPath(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = getPath(root.left);
        int right = getPath(root.right);
        res = Math.max(res, left + right +1);
        return Math.max(left, right) + 1;
    }
}

/**
 * 官方题解：
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/solution/er-cha-shu-de-zhi-jing-by-leetcode-solution/
 */