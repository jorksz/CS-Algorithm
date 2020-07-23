package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0){
            return new ArrayList<>();
        }

        return helper(1, n);
    }

    private List<TreeNode> helper(int low, int high) {
        List<TreeNode> treeNodes = new ArrayList<>();
        if (low > high){
            treeNodes.add(null);
            return treeNodes;
        }

        for (int i = low; i < high; i++){
            List<TreeNode> left = helper(low, i - 1);
            List<TreeNode> right = helper(i+1, high);

           for (TreeNode treeNode : left){
               for (TreeNode treeNode1 : right){
                   TreeNode node = new TreeNode(i);
                   node.left = treeNode;
                   node.right = treeNode1;
                   treeNodes.add(node);
               }
           }
        }
        return treeNodes;
    }
}
