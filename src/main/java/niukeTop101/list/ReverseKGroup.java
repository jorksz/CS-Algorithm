package niukeTop101.list;

public class ReverseKGroup {

    /**
     *
     * @param head ListNode类
     * @param k int整型
     * @return ListNode类
     */
    public ListNode reverseKGroup (ListNode head, int k) {
        // write code here
        if (head == null) {
            return null;
        }
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            if (tail == null) {
                return head;
            }
            tail = tail.next;
        }

        ListNode pre = null;
        ListNode temp = head;
        // 翻转尾结点之前的
        while (temp != tail) {
            ListNode cur = temp.next;
            temp.next = pre;
            pre = temp;
            temp = cur;
        }

        head.next = reverseKGroup(tail, k);
        return pre;
    }

}
