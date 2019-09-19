package leetcode.stack;

import java.util.LinkedList;

/**
 * 题目
 *
 * 计算逆波兰式（后缀表达式）的值
 * 运算符仅包含"+","-","*"和"/"，被操作数可能是整数或其他表达式
 * 例如：
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9↵  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */

public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0){
            return 0;
        }

        LinkedList<Integer> stack = new LinkedList<>();

        for(int i = 0; i < tokens.length; i++){
            if(!stack.isEmpty() && (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/"))){
                int num2 = stack.poll();
                int num1 = stack.poll();
                stack.push(operation(tokens[i], num1, num2));
            }
            else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }

        return stack.peek();
    }

    private Integer operation(String token, int num1, int num2) {

        switch (token){
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;

                default:
                    return 0;
        }
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation object = new EvaluateReversePolishNotation();
        String[] testCase = {"4","13","5","/", "+"};
        System.out.println(object.evalRPN(testCase));
    }
}


/**
 *  解题思路
 *
 *  利用栈的特性将数字入栈，遍历数组当匹配到特殊符号的时候进行运算，需要注意程序鲁棒性
 */
