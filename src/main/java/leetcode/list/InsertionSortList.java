package leetcode.list;


/**
 * 题目
 *
 * 使用插入排序对链表进行排序。
 * Sort a linked list using insertion sort.
 */

public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        if(head == null){
            return head;
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = head;

        while (cur != null){
            //插入排序的核心，使得又回到dummy头结点
            ListNode pre = dummy;
            //暂存下当前结点的下一个结点，为了下面的结点后移
            ListNode next = cur.next;
            //找到比当前结点大的值，然后插入
            while (pre.next != null && pre.next.val <= cur.val){
                pre = pre.next;
            }
            //链表的插入操作
            cur.next = pre.next;
            pre.next = cur;
            //后移
            cur = next;
        }

        return dummy.next;
    }
}

/**
 * 解题思路
 *
 * 题目要求 用插入排序，理解插入排序的定义，那么剩下的就是链表的基本操作了
 * 这里需要注意这里最好新建一个链表头，方便可能与第一个结点进行交换
 */


