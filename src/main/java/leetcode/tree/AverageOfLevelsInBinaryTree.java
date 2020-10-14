package leetcode.tree;

import java.util.*;

public class AverageOfLevelsInBinaryTree {

    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        List<Double> res = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()){
            double sum = 0;
            int count = deque.size();
            for (int i = 0; i < count; i++){
                TreeNode temp = deque.poll();
                sum += temp.val;
                if (temp.left != null){
                    deque.offer(temp.left);
                }
                if (temp.right != null){
                    deque.offer(temp.right);
                }
            }
            res.add(sum / count);
        }
        return res;
    }
}
