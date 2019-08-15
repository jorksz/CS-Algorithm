package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;


/**
 * 题目
 *
 * 求给定的二叉树的后序遍历。
 * 例如：
 * 给定的二叉树为{1,#,2,3},
 * 1↵    ↵     2↵    /↵   3↵
 * 返回[3,2,1].
 * 备注；用递归来解这道题太没有新意了，可以给出迭代的解法么？
 *
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * For example:
 * Given binary tree{1,#,2,3},
 * return[3,2,1].
 * Note: Recursive solution is trivial, could you do it iteratively?
 */

public class BinaryTreePostorderTraversal {

    /**
     * 递归
     * @param root
     * @return
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        ArrayList<Integer> res = new ArrayList<>();
        helper(root,res);
        return res;
    }

    private void helper(TreeNode root,  ArrayList<Integer> res) {
        if(root == null){
            return;
        }
        helper(root.left,res);
        helper(root.right,res);
        res.add(root.val);
    }

    /**
     * 迭代
     * @param root
     * @return
     */
    public ArrayList<Integer> postorderTraversal2(TreeNode root){
        if(root == null){
            return new ArrayList<>();
        }

        ArrayList<Integer> res = new ArrayList<>();

        LinkedList<TreeNode> stack = new LinkedList<>();

        stack.push(root);
        TreeNode pre = null;
        while(!stack.isEmpty()){
            TreeNode cur = stack.peek();
            if(pre == null || pre.left == cur || pre.right == cur){
                if(cur.left != null){
                    stack.push(cur.left);
                }

                else if(cur.right != null){
                    stack.push(cur.right);
                }
                else {
                    res.add(cur.val);
                    stack.pop();
                }
            }

            else if(cur.left == pre && cur.right != null){
                stack.push(cur.right);
            }

            else{
                res.add(cur.val);
                stack.pop();
            }

            pre = cur;
        }
        return res;
    }
}


/**
 * 迭代解题思路
 *
 *我们需要维护当前遍历的cur指针和前一个遍历的pre指针来追溯当前的情况（注意这里是遍历的指针，并不是真正按后序访问顺序的结点）。
 * 具体分为几种情况：
 * （1）如果pre的左孩子或者右孩子是cur，那么说明遍历在往下走，按访问顺序继续，
 *          即如果有左孩子，则是左孩子进栈，否则如果有右孩子，则是右孩子进栈，
 *          如果左右孩子都没有，则说明该结点是叶子，可以直接访问并把结点出栈了。
 * （2）如果反过来，cur的左孩子是pre，则说明已经在回溯往上走了，
 *          但是我们知道后序遍历要左右孩子走完才可以访问自己，所以这里如果有右孩子还需要把右孩子进栈，
 *          否则说明已经到自己了，可以访问并且出栈了。
 * （3）如果cur的右孩子是pre，那么说明左右孩子都访问结束了，可以轮到自己了，访问并且出栈即可。
 * 算法时间复杂度也是O(n)，空间复杂度是栈的大小O(logn)
 */