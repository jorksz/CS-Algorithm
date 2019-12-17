package leetcode.tree;

/**
 * 题目
 *
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 */

public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(q == null && p == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }

        if(p.val != q.val){
            return false;
        }

        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}

/**
 *  解题思路
 *
 *  递归，先判断是否存在这个结点，再判断相同结点值是否相同。为true话，继续走下一个结点
 */