package leetcode.list;


/**
 * 题目
 *
 * 给定一个链表，删除链表的倒数第n个节点并返回链表的头指针
 * 例如，
 *    给出的链表为:1->2->3->4->5, n= 2.↵↵   删除了链表的倒数第n个节点之后,链表变为1->2->3->5.
 * 备注：
 * 题目保证n一定是合法的
 * 请尝试只用一步操作完成该功能
 *
 * Given a linked list, remove the n th node from the end of list and return its head.
 * For example,
 *
 *    Given linked list:1->2->3->4->5, andn= 2.↵↵   After removing the second node from the end, the linked list becomes1->2->3->5.↵
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 */


public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n < 0){
            return null;
        }

        ListNode fast = head;
        int i = 0;
        while(fast != null && i < n){
            fast = fast.next;
            i++;
        }

        if(i < n){
            return head;
        }

        if(fast == null){
            return head.next;
        }

        ListNode slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return head;
    }
}


/**
 * 解题思路
 *
 * 链表的基本删除操作，这里只需注意如何定位倒数第n个结点，这里可以先让快指针走，直到i = n
 * 然后让慢指针开始走，快指针到终点时，慢指针刚好到倒数第n个结点，这时候进行删除就行
 *
 * 这里需要注意两个边界情况，一个是i<n,也就是走不到这个结点，这时候就直接返回head结点
 * 2、当fast == null 也就是 i = n的时候，这时候需要删除的结点就是头结点，
 * 那么我们这里只需要返回头结点的下一个结点就行
 */
