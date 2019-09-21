package leetcode.list;


/**
 * 题目
 *
 * 对于一个给定的链表，返回环的入口节点，如果没有环，返回null
 * 拓展：
 * 你能给出不利用额外空间的解法么？
 */
public class LinkedListCycle2 {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode meetNode = null;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
                meetNode = slow;
                break;
            }
        }
        if(meetNode == null){
            return null;
        }

        ListNode node1 = slow;
        fast = head;

        while (node1 != fast){
            node1 = node1.next;
            fast = fast.next;
        }

        return node1;
    }

}

/**
 * 解题思路
 *
 * 快慢指针找出相遇的位置，然后同时推进，当他们再次相遇的时候那就是环的入口
 *
 */
