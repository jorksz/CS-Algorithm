package offer.linked_list;

import java.util.ArrayList;
import java.util.Stack;


/**
 * 题目-从尾到头打印链表
 *输入一个链表，按链表从尾到头的顺序返回一个ArrayList
 */
public class FromRearToHeadPrintLinkedList {
    /**
     * 合理使用递归解法
     * @param listNode
     * @return
     */
    ArrayList<Integer> res = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode != null){
            printListFromTailToHead(listNode.next);
            res.add(listNode.val);
        }
        return res;

    }

    /**
     * 利用栈来解决 先进后出
     */
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        if(listNode == null){
            return new ArrayList<>();
        }

        Stack<ListNode> node = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();

        while(listNode != null){
            node.push(listNode);
            listNode = listNode.next;
        }

        while(!node.isEmpty()){
            res.add(node.pop().val);
        }

        return res;
    }


}
