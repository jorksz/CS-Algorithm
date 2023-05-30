package niukeTop101.tree;

import java.util.ArrayList;
import java.util.List;

public class BM24 {

    public int[] inorderTraversal (TreeNode root) {
        // write code here

        List<Integer> integerList = new ArrayList<>();
        helper(root, integerList);
        return integerList.stream().mapToInt(i ->i).toArray();
    }
    public void helper(TreeNode treeNode, List<Integer> integerList) {
        if (treeNode == null) {
            return;
        }
        helper(treeNode.left, integerList);
        integerList.add(treeNode.val);
        helper(treeNode.right, integerList);
    }
}
