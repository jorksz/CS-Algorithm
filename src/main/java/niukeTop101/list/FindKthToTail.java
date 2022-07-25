package niukeTop101.list;

public class FindKthToTail {


    /**
     * @param pHead ListNode类
     * @param k int整型
     * @return ListNode类
     */
    public ListNode FindKthToTail (ListNode pHead, int k) {
        // write code here
        ListNode temp = pHead;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        ListNode cur = pHead;
        int curCount= 0;
        while (cur != null) {
            if (count - curCount == k) {
                return cur;
            }
            cur = cur.next;
            curCount++;
        }
        return null;
    }

    public ListNode FindKthToTail1 (ListNode pHead, int k) {
        ListNode fast = pHead;
        while (k > 0 && fast != null) {
            fast = fast.next;
            k--;
        }
        if (k > 0) {
            return null;
         }
         ListNode slow = pHead;
        while (fast != null) {
            fast = fast.next;
             slow = slow.next;
         }
         return slow;
    }
}
