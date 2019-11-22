package leetcode.stack;


import java.util.Stack;

/**
 * 题目
 *
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 */

public class MinStack {
    Stack<Integer> res;
    Stack<Integer> helper;
    public MinStack() {
        res = new Stack<>();
        helper = new Stack<>();
    }

    public void push(int x) {
        res.push(x);
        if (helper.isEmpty() || x <= helper.peek()){
            helper.push(x);
        }
    }

    public void pop() {
       if (!res.isEmpty()){
           if(res.pop().equals( helper.peek())){
               helper.pop();
           }

       }
    }

    public int top() {
        if(!res.isEmpty()){
            return res.peek();
        }
       return -1;
    }

    public int getMin() {
        if (!helper.isEmpty()){
            return helper.peek();
        }

        return -1;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(1);
        minStack.push(2);
        System.out.println(minStack.getMin());
    }
}
