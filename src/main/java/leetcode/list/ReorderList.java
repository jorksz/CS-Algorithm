package leetcode.list;

/**
 * 题目
 *
 * 将给定的单链表L： L 0→L 1→…→L n-1→L n,
 * 重新排序为： L 0→L n →L 1→L n-1→L 2→L n-2→…
 * 要求使用原地算法，并且不改变节点的值
 * 例如：
 * 对于给定的单链表{1,2,3,4}，将其重新排序为{1,4,2,3}.
 */

public class ReorderList {

    /**
     * 解题思路
     * 分3步走，第一步拆分链表，将链表拆分成两部分，用快慢指针
     * 第二步，将后半部分链表逆置，使用头插法
     * 第三步，合并链表，但是这里不需要比较大小，依次交替合并链表就行
     */
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // 后半部分
        ListNode temp = slow.next;
        // 从中间断开
        slow.next = null;
        // 前半部分
        ListNode pre = head;
        // 反转后半部分的链表
        ListNode last = reverse(temp);
        // 合并
        while (last != null && pre != null){
            ListNode next = last.next;
            last.next = pre.next;
            pre.next = last;
            //指针后移
            pre = last.next;
            last = next;
        }
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


    public void reorderList2(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        ListNode back = head;
    }
}

/**
 * 解题思路
 *
 * 分3步走，第一步拆分链表，将链表拆分成两部分，用快慢指针
 * 第二步，将后半部分链表逆置，使用头插法
 * 第三步，合并链表，但是这里不需要比较大小，依次交替合并链表就行
 */
