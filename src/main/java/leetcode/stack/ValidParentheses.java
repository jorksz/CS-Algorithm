package leetcode.stack;


import java.util.Stack;

/**
 * 题目
 *
 * 给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列
 * 括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法。
 *
 * Given a string containing just the characters'(',')','{','}','['and']',
 * determine if the input string is valid.
 * The brackets must close in the correct order,"()"and"()[]{}"are all valid but"(]"and"([)]"are not.
 */


public class ValidParentheses {

    public static boolean isValid(String s) {
        if(s == null || s.length() == 0){
            return true;
        }

        char[] chars = s.toCharArray();

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < chars.length; i++){
            switch (chars[i]){
                case '(':
                case '{':
                case '[':
                    stack.push(chars[i]);
                    break;
                case ')':
                    if(stack.isEmpty() || stack.pop() != '('){
                        return false;
                    }
                    break;
                case ']':
                    if(stack.isEmpty() || stack.pop() != '['){
                        return false;
                    }
                    break;
                case '}':
                    if(stack.isEmpty() || stack.pop() != '{'){
                        return false;
                    }
                    break;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "{[]}{";
        System.out.println(isValid(s));
    }
}

/**
 * 这题是我当时的面试题，当时没写出来，现在觉得好可惜0.0
 *
 * 解题思路：
 * 思路比较简单，利用栈的特点，先遍历然后把左边符号入栈，如果当前符号为右边符号时，出栈判断符号是否想匹配，不是直接返回false
 */
