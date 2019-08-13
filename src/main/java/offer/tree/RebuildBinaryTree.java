package offer.tree;

public class RebuildBinaryTree {

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {

        if(pre == null || pre.length == 0 || in == null || in.length == 0){
            return null;
        }

        return helper(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private TreeNode helper(int[] pre, int pres, int pree, int[] in, int ins, int ine) {
        if(pres > pree || ins > ine){
            return null;
        }

        TreeNode node = new TreeNode(pre[pres]);

        for(int i = ins; i <= ine; i++){
            if(pre[pres] == in[i]) {
                node.left = helper(pre, pres + 1, i - ins + pres, in, ins, i - 1);
                node.right = helper(pre, i -ins + pres + 1, pree,in, i + 1 , ine );
            }
        }

        return node;
    }
}
