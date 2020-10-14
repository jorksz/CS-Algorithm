package leetcode.tree;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberIII {
    //选择 o节点的情况下，o节点的子树上被选择的节点的最大权值和
    Map<TreeNode, Integer> f = new HashMap<>();
    //表示不选择 o节点的情况下，o节点的子树上被选择的节点的最大权值和
    Map<TreeNode, Integer> m = new HashMap<>();
    public int rob(TreeNode root) {
        dfs(root);
        return Math.max(f.getOrDefault(root, 0), m.getOrDefault(root, 0));
    }

    private void dfs(TreeNode root) {
        if (root == null){
            return;
        }
        dfs(root.left);
        dfs(root.right);
        f.put(root,  root.val + m.getOrDefault(root.left, 0) + m.getOrDefault(root.right, 0));
        m.put(root,Math.max(f.getOrDefault(root.left, 0), m.getOrDefault(root.left, 0)) + Math.max(f.getOrDefault(root.right, 0), m.getOrDefault(root.right, 0)));
    }
}
