package leetcode.find;

import java.util.ArrayList;


/**
 * 题目
 *
 * 给出n对括号，请编写一个函数来生成所有的由n对括号组成的合法组合。
 * 例如，给出n=3，解集为：
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 */


public class GenerateParentheses {

    public ArrayList<String> generateParenthesis(int n) {
        if(n < 1){
            return new ArrayList<>();
        }

        ArrayList<String> res = new ArrayList<>();
        helper(n,n, new String(), res);
        return res;
    }

    private void helper(int left, int right, String s, ArrayList<String> res) {

        if(right < left){
            return;
        }
        if(left == 0 && right == 0){
            res.add(s);

        }

        if(left > 0){
            helper(left - 1, right, s+"(", res);
        }

        if(right > 0){
            helper(left, right - 1, s+")", res);
        }

    }

    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        System.out.println(generateParentheses.generateParenthesis(3));
    }
}

/**
 *递归解决。
 * 注意递归边界  左右数是一样的，所以这里我们先递归左边，所以停止条件时当右数量小于左数量
 * 何时添加数据呢，也递归到左 、右数量都为0 的时候，就可以加入到集合中
 * 先递归左括号，再递归右括号
 */