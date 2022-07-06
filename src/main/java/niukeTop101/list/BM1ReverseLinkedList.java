package niukeTop101.list;

import niukeTop101.list.ListNode;

public class BM1ReverseLinkedList {

    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode pre = null;
        ListNode temp = head;

        while (temp != null) {
            // 存储当前节点
            ListNode cur = temp.next;
            // 修改指向
            temp.next = pre;
            pre = temp;
            // 继续往下
            temp = cur;
        }

        return pre;
    }
}
