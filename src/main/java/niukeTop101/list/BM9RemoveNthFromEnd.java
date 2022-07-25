package niukeTop101.list;

import java.util.ArrayList;
import java.util.List;

public class BM9RemoveNthFromEnd {
    /**
     *
     * @param head ListNode类
     * @param n int整型
     * @return ListNode类
     */
    public ListNode removeNthFromEnd (ListNode head, int n) {
        // write code here
        List<ListNode> nodeList = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            nodeList.add(temp);
            temp = temp.next;
        }

        int size = nodeList.size();
        ListNode dummy = new ListNode(-1);
        ListNode tempDummy = dummy;
        for (int i = 0; i < size; i++) {
            if (size - i == n) {
                continue;
            }
            tempDummy.next = new ListNode(nodeList.get(i).val);
            tempDummy = tempDummy.next;
        }

        return dummy.next;
    }

    public ListNode removeNthFromEnd2 (ListNode head, int n) {
        // write code here

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = dummy;
        while (n > 0 && fast != null) {
            fast = fast.next;
            n--;
        }

        while (fast != null) {
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }

        if (slow != null) {
            pre.next = slow.next;
        }

        return dummy.next;
    }
}
