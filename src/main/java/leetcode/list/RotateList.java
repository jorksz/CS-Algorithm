package leetcode.list;


/**
 * 旋转链表
 *
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 */
public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }

        int count = 1;

        ListNode old = head;

        while (old != null && old.next != null){
            old = old.next;
            count++;
        }

        //连接成环
        old.next = head;

        ListNode news = head;

        k = count - k % count;

        while (k-- > 1){
            news = news.next;
        }

        old = news.next;
        //断开
        news.next = null;

        return old;
    }
}

/**
 * 解题思路
 *
 * 先统计链表的长度，然后算出k的位置，（k可能也大于链表长度)
 * 这里我是把链表弄成环，然后再次遍历到要旋转的位置，将链表断开即可
 *
 * 时间复杂度为O(n)
 * 空间为O（1）
 */