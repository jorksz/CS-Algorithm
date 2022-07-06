package niukeTop101.list;

import java.util.List;

public class ReverseBetween {

    /**
     *
     * @param head ListNode类
     * @param m int整型
     * @param n int整型
     * @return ListNode类
     */
    public ListNode reverseBetween (ListNode head, int m, int n) {
        // write code here
        // 构建一个虚拟的头结点
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode pre = dummyNode;
        // m 由题意保证是必须存在的，所以可以用这种方法找到m这节点
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }

        ListNode rightNode = pre;
        for (int i = 0; i <= n - m; i++) {
            rightNode = rightNode.next;
        }

        ListNode leftNode = pre.next;
        ListNode tempRightNode = rightNode.next;
        pre.next = null;
        rightNode.next = null;

        // 1->2->3 -> 3->2->1
        reverseNode(leftNode);

        pre.next = leftNode;
        leftNode.next = tempRightNode;
        return dummyNode.next;
    }

    private void reverseNode(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode temp = head;
        ListNode pre = null;
        while (temp != null) {
            ListNode cur = temp.next;
            temp.next = pre;
            pre = temp;
            temp = cur;
        }
    }
}
