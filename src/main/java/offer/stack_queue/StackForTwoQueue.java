package offer.stack_queue;


import java.util.Stack;

/**
 * 题目 - 用两个栈实现队列
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class StackForTwoQueue {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);

    }

    public int pop() {
        while (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    public static void main(String[] args) {
        StackForTwoQueue res = new StackForTwoQueue();
        res.push(1);
        res.push(2);
        res.push(3);
        System.out.print(res.pop() + " ");
        System.out.print(res.pop()+ " ");
        res.push(4);
        System.out.print(res.pop()+ " ");
        res.push(5);
        System.out.print(res.pop()+ " ");
        System.out.print(res.pop()+" ");
    }
}

/**
 *解题思路
 *
 * 栈先进后出，两个栈组合使用就是先进先出了。 stack1是进队列的，stack2出队列
 * 这里需要注意点小细节
 * 出队列的时候，需要判断stack2是否为空，只有当为空时候才能进将stack1出栈的值加入stack2，否则先把stack2里面的值排空
 */