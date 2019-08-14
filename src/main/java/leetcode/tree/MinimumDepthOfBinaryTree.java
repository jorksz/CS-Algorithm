package leetcode.tree;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;

/**
 * 题目
 * 求给定二叉树的最小深度。最小深度是指树的根结点到最近叶子结点的最短路径上结点的数量。
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */


/**
 * 解题思路
 *
 * 判断最小深度，需要考虑叶子节点，所以需要判断左右子树是否为叶子节点
 */



public class MinimumDepthOfBinaryTree {

    /**
     * 递归解法
     * @param root
     * @return
     */
    public int run(TreeNode root) {
        if(root == null){
            return 0;
        }

        if(root.left == null){
            return run(root.right) + 1;
        }

        if(root.right == null){
            return run(root.left) + 1;
        }

        return Math.min((run(root.left)),run(root.right)) + 1;
    }


    /**
     * 非递归的方式 --层序遍历
     */
    public int run2(TreeNode root) {
        if(root == null){
            return 0;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();

        int level = 1;
        int lastNum = 1;
        int curNum = 0;

        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.right == null && node.left == null){
                return level;
            }
            lastNum --;
            if(node.left != null){
                queue.offer(node.left);
                curNum++;
            }

            if(node.right != null){
                queue.offer(node.right);
                curNum++;
            }

            if(lastNum == 0){
                lastNum = curNum;
                curNum = 0;
                level++;
            }
        }

        return 0;
    }
}
