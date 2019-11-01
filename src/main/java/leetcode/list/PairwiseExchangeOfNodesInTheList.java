package leetcode.list;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *  
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 */
public class PairwiseExchangeOfNodesInTheList {

    public ListNode swapPairs(ListNode head) {
        if(head == null){
            return head;
        }


        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = pre.next;

        while (cur != null && cur.next != null){
            ListNode temp = cur.next;
            ListNode next = temp.next;

            pre.next = temp;
            temp.next = cur;

            pre = cur;
            cur = next;
        }
        pre.next = cur;

        return dummy.next;
    }


    /**
     * 递归解法
     * @param head
     * @return
     */
    public ListNode swapPairs2(ListNode head) {
        if(head == null && head.next == null){
            return head;
        }

        ListNode next = head.next;
        head.next = swapPairs2(next.next);
        next.next = head;

        return next;

    }
}
