package offer.linked_list;

/**
 * 链表中环的入口结点
 *
 *给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class EntryPointList {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null ){
            return null;
        }

        ListNode fast = pHead;
        ListNode slow = pHead;

        //判断是否有环
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                break;
            }
        }
        if (fast == null || fast.next == null){
            return null;
        }
        //找到环的入口
        ListNode newSlow = pHead;
        while (fast != newSlow){
            fast = fast.next;
            newSlow = newSlow.next;
        }
        return newSlow;
    }
}

/**
 * 解题思路
 * https://www.nowcoder.com/questionTerminal/253d2c59ec3e4bc68da16833f79a38e4?f=discussion
 */