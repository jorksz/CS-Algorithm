package leetcode.list;


/**
 * 题目
 * 判断给定的链表中是否有环
 * 扩展：
 * 你能给出不利用额外空间的解法么？
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                return true;
            }
        }

        return false;
    }

}

/**
 *解题思路
 *
 * 快慢指针解决，当快的走完，慢的走了一半，如果有环他们就会相遇。
 *
 * 这里需要注意一个小细节，就是先走再比较
 */