package niukeTop101.list;

import java.util.ArrayList;
import java.util.List;

public class BM14OddEvenList {

    public ListNode oddEvenList (ListNode head) {
        // write code here

        ListNode countTempHead = head;
        int count = 0;
        List<Integer> odds = new ArrayList<>();
        List<Integer> evens = new ArrayList<>();
        while (countTempHead != null) {
            count++;
            if (count % 2 == 0) {
                evens.add(countTempHead.val);
            } else {
                odds.add(countTempHead.val);
            }
            countTempHead = countTempHead.next;
        }

        ListNode dummy = new ListNode(-1);
        ListNode tempDummy = dummy;
        for (Integer odd : odds) {
            tempDummy.next = new ListNode(odd);
            tempDummy = tempDummy.next;
        }

        for (Integer even : evens) {
            tempDummy.next = new ListNode(even);
            tempDummy = tempDummy.next;
        }

        tempDummy.next = null;
        return dummy.next;
    }

    /**
     * 双指针写法
     * @param head
     * @return
     */
    public ListNode oddEvenList1 (ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode tempEven = even;
        while (tempEven != null && tempEven.next != null) {
            odd.next = tempEven.next;
            odd = odd.next;
            tempEven.next = odd.next;
            tempEven = tempEven.next;
        }

        odd.next = even;
        return head;
    }
}
