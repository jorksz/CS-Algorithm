package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 题目
 * 求给定的二叉树的前序遍历。
 */
public class BinaryTreePreorderTraversal {
    /**
     * 递归解法
     * @param root
     * @return
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }

        ArrayList<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, ArrayList<Integer> res) {
        if(root == null){
            return;
        }

        res.add(root.val);
        helper(root.left, res);
        helper(root.right, res);
    }

    /**
     * 迭代版本
     * @param root
     * @return
     */
    public ArrayList<Integer> preorderTraversal2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            res.add(temp.val);
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }


        }

        return res;
    }
}

/**
 *解题思路
 *
 * 递归版本，按根-左-右进行递归即可
 *
 * 迭代版本
 *
 * 通过栈的特性先进后出，逐步迭代，注意先添加右结点，在添加左结点
 */