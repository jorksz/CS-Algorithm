package leetcode.list;


/**
 * 题目
 *
 * 将给出的链表中的节点每k个一组翻转，返回翻转后的链表
 * 如果链表中的节点数不是k的倍数，将最后剩下的节点保持原样
 * 你不能更改节点中的值，只能更改节点本身。
 * 只允许使用常数级的空间
 * 例如：
 * 给定的链表是1->2->3->4->5
 *
 * 对于 k = 2, 你应该返回 2->1->4->3->5
 *
 * 对于 k = 3, y你应该返回 3->2->1->4->5
 *
 *
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 *
 * You may not alter the values in the nodes, only nodes itself may be changed.
 *
 * Only constant memory is allowed.
 *
 * For example,
 * Given this linked list:1->2->3->4->5
 *
 * For k = 2, you should return:2->1->4->3->5
 *
 * For k = 3, you should return:3->2->1->4->5
 */


public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null ){
            return null;
        }

        ListNode duumy = new ListNode(0);
        duumy.next = head;
        ListNode pre = duumy;
        ListNode cur = head;
        int count = 0;

        while(cur != null){
            ListNode end = cur.next;
            count++;
            if(count == k){
                pre = helper(pre, end);
                count = 0;
            }

            cur = end;
        }

        return duumy.next;

    }

    private ListNode helper(ListNode pre, ListNode end) {

        if(pre == null || pre.next == null){
            return null;
        }

        ListNode head = pre.next;
        ListNode cur = pre.next.next;

        while(cur != end){
            ListNode next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
        }

        //逆置完之后将逆置的最后一个结点接在 k+1结点之后
        head.next = end;

        return head;
    }
}

/**解题思路
 *
 * 统计目前节点数量，如果到达k，就把当前k个结点reverse，
 * 这里需要reverse linked list的subroutine。
 * 这里我们需要先往前走，到达k的时候才做reverse，所以总体来说每个结点会被访问两次。
 * 总时间复杂度是O(2*n)=O(n)，空间复杂度是O(1)
 */
