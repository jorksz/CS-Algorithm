package niukeTop101.tree;


import java.util.ArrayList;
import java.util.List;

public class BM23PreorderTraversal {

    public int[] preorderTraversal (TreeNode root) {
        // write code here
        List<Integer> list = new ArrayList<>();
        recursion(root, list);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void recursion(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        if (root.left != null) {
            recursion(root.left, res);
        }
        if (root.right != null) {
            recursion(root.right, res);
        }
    }
}
