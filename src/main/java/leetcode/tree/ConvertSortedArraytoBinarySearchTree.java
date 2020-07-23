package leetcode.tree;

public class ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length -1);
    }

    private TreeNode helper(int[] nums, int left, int right) {
        if (left > right){
            return null;
        }
        int mid = (left + right) /2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = helper(nums, left, mid -1);
        treeNode.right = helper(nums, mid + 1, right);
        return treeNode;

    }
}
