package leetcode.list;


/**
 *将给定的链表中每两个相邻的节点交换一次，返回链表的头指针
 * 例如,
 * 给出1->2->3->4，你应该返回链表2->1->4->3。
 * 你给出的算法只能使用常量级的空间。你不能修改列表中的值，只能修改节点本身。
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * For example,
 * Given1->2->3->4, you should return the list as2->1->4->3.
 *
 * Your algorithm should use only constant space.
 * You may not modify the values in the list, only nodes itself can be changed.
 *
 */

public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if(head == null){
            return head;
        }

        ListNode  duumy = new ListNode(0);
        duumy.next = head;
        ListNode pre = duumy;
        ListNode cur = head;
        int count = 0;


        while(cur != null){
            ListNode next = cur.next;
            count++;
            if(count == 2) {
                pre = helper(pre, next);
                count = 0;
            }
            cur = next;
        }

        return duumy.next;
    }

    private ListNode helper(ListNode pre, ListNode next) {

        if(pre == null || pre.next == null){
            return pre;
        }

        ListNode head = pre.next;
        ListNode cur = pre.next.next;

        while(cur != next){
            ListNode temp = cur.next;
            cur.next = pre;
            cur = temp;
        }

        head.next = next;

        return head;
    }
}
