package niukeTop101.list;

public class BM13IsPail {

    /**
     * 双指针
     * 找到中点，然后把后边那一节翻转，再与前边半截进行值比较
     * @param head
     * @return
     */
    public boolean isPail (ListNode head) {
        // write code here

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 后半截翻转
        slow = reserve(slow);
        // 前半截
        fast = head;
        while (slow != null) {
            if (slow.val != fast.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    private ListNode reserve (ListNode head) {
        ListNode pre = null;
        ListNode temp = head;
        while (temp != null) {
            ListNode cur = temp.next;
            temp.next = pre;
            pre = temp;
            temp = cur;
        }

        return pre;
    }
}
