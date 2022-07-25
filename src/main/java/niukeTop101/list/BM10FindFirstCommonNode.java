package niukeTop101.list;

public class BM10FindFirstCommonNode {

    /**
     * 双指针
     * 也可以用HashSet来存储
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode pHead1Temp = pHead1;
        ListNode pHead2Temp = pHead2;
        while (pHead1Temp != pHead2Temp) {
            if (pHead1Temp != null) {
                pHead1Temp = pHead1Temp.next;
            }
            if (pHead2Temp != null) {
                pHead2Temp = pHead2Temp.next;
            }
            if (pHead1Temp != pHead2Temp) {
                if (pHead1Temp == null) {
                    pHead1Temp = pHead2;
                }
                if (pHead2Temp == null) {
                    pHead2Temp = pHead1;
                }
            }
        }

        return null;
    }
}
