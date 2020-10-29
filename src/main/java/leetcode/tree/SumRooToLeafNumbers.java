package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class SumRooToLeafNumbers {
    // 深度优先遍历，通过当前结果推算下一次的结果。
    // 递归结束条件，1. root == null 2.当前节点是叶子节点
    // 每次递归只需要计算当前结果，当前结果即为当前节点值 + 前一次递归*10的值
    // 最后统计左右子树的值即可。
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int value) {
        if (root == null) {
            return 0;
        }

        int sum = root.val + value * 10;
        if (root.left == null && root.right == null) {
            return sum;
        }
        return dfs(root.left, sum) + dfs(root.right, sum);
    }
}
