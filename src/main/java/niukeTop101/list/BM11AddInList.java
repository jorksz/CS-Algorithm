package niukeTop101.list;

public class BM11AddInList {

    /**
     * 此招不行，数字爆了
     * @param head1
     * @param head2
     * @return
     */
    public ListNode addInList (ListNode head1, ListNode head2) {
        // write code here
        StringBuilder builder = new StringBuilder();
        StringBuilder builder1 = new StringBuilder();
        ListNode temp1 = head1;
        while (temp1 != null) {
            builder.append(temp1.val);
            temp1 = temp1.next;
        }

        ListNode temp2 = head2;
        while (temp2 != null) {
            builder1.append(temp2.val);
            temp2 = temp2.next;
        }

        long num1 = Long.parseLong(builder.toString());
        long num2 = Long.parseLong(builder1.toString());
        long res = num1 + num2;
        String strRes = String.valueOf(res);
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for (int i = 0; i < strRes.length(); i++) {
            cur.next = new ListNode(Integer.parseInt(String.valueOf(strRes.charAt(i))));
            cur = cur.next;
        }
        return dummy.next;
    }

    public ListNode addInList2 (ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        ListNode reserveNode = reserveList(head1);
        ListNode reserveNode2 = reserveList(head2);

        ListNode tempNode1 = reserveNode;
        ListNode tempNode2 = reserveNode2;
        int carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while (tempNode1 != null || tempNode2 != null || carry != 0) {

            int val1 = tempNode1 == null ? 0 : tempNode1.val;
            int val2 = tempNode2 == null ? 0 : tempNode2.val;
            int value = val1 + val2 + carry;
            carry = value / 10;
            pre.next = new ListNode(value % 10);
            pre = pre.next;
            if (tempNode1 != null) {
                tempNode1 = tempNode1.next;
            }

            if (tempNode2 != null) {
                tempNode2 = tempNode2.next;
            }
        }

        return reserveList(dummy.next);
    }

    private ListNode reserveList(ListNode head) {
        ListNode temp = head;
        ListNode pre = null;
        while (temp != null) {
            ListNode cur = temp.next;
            temp.next = pre;
            pre = temp;
            temp = cur;
        }
        return pre;
    }

    public static void main(String[] args) {
        int[] array1 = {5,9,7,5,7,1,2,6,4,2,7,8,9,6,1,6,6,1,1,4,2,9,5,5,0,4,6,3,0,4,3,5,6,7,0,5,5,4,4,0};
        int[] array2 = {1,3,2,5,0,6,0,2,1,4,3,9,3,0,9,9,0,3,1,6,5,7,8,6,2,3,8,5,0,9,7,9,4,5,9,9,4,9,3,6};
        ListNode head1 = new ListNode(-1);
        ListNode temp1 = head1;
        for (int i = 0; i <array1.length; i++) {
            temp1.next = new ListNode(array1[i]);
            temp1 = temp1.next;
        }

        ListNode head2 = new ListNode(-1);
        ListNode temp2 = head2;
        for (int i = 0; i < array2.length; i++) {
            temp2.next =new ListNode(array2[i]);
            temp2 = temp2.next;
        }

        BM11AddInList bm11AddInList = new BM11AddInList();
        bm11AddInList.addInList2(head1.next, head2.next);

    }
}
