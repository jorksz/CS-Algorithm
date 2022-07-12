package niukeTop101.list;

import java.util.HashSet;
import java.util.Set;

public class HasCycle {

    /**
     * 快慢指针
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }


    /**
     * Set记录遍历过的节点，有环的话必定是包含在里边的
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        Set<ListNode> listNodeSet = new HashSet<>();
        ListNode temp = head;
        while (temp != null) {
            if (listNodeSet.contains(temp)) {
                return true;
            }
            listNodeSet.add(temp);
            temp = temp.next;
        }
        return false;
    }
}
