package niukeTop101.list;

import java.util.HashSet;
import java.util.Set;

public class BM7HasCycle {

    public ListNode EntryNodeOfLoop1(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }

    public ListNode EntryNodeOfLoop(ListNode head) {
        Set<ListNode> listNodeSet = new HashSet<>();
        ListNode temp = head;
        while (temp != null) {
            if (listNodeSet.contains(temp)) {
                return temp;
            }
            listNodeSet.add(temp);
            temp = temp.next;
        }
        return null;
    }
}
