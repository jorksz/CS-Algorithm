package leetcode.list;

/**
 * 题目
 *
 * 反转一个单链表
 */

public class ReverseLinkedList {

    /**
     * 迭代
     *
     * 时间复杂度O（n)
     * 空间复杂度O（1）
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode pre = null;

        ListNode cur = head;

        while (cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        return pre.next;
    }


    /**
     * 递归
     * 时间复杂度O（n)
     * 空间复杂度O（1）
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if(head == null || head.next ==null ){
            return head;
        }

        ListNode pre = reverseList2(head.next);
        head.next.next = head;
        head.next = null;

        return pre;
    }
}
