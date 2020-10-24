package leetcode.list;

public class PalindromeLinkedList {
    /**
     * 思路 和 Reorder List 结题思路差不多， 判断链表是否是回文链表， 可以通过快慢指针找到链表中点
     * 然后反转后半部分链表， 最后比较即可。
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (slow.next == null) {
            return false;
        }
        ListNode temp = slow.next;
        slow.next = null;
        ListNode newHead = head;
        ListNode last = reverse(temp);
        while (last != null && newHead != null) {
            if (last.val != newHead.val) {
                return false;
            }
            last = last.next;
            newHead = newHead.next;
        }
        return false;

    }

    private ListNode reverse(ListNode temp) {
        if(temp == null){
            return temp;
        }

        ListNode cur = temp;
        ListNode pre = null;

        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}
