package niukeTop101.list;

public class MergeList {

    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode dummyNode = new ListNode(-1);
        ListNode cur = dummyNode;
        while (list1 != null && list2!= null) {
            if (list1.val >= list2.val) {
                cur.next = new ListNode(list2.val);
                list2 = list2.next;
            } else {
                cur.next = new ListNode(list1.val);
                list1 = list1.next;
            }
            cur = cur.next;
        }
        if (list1 == null) {
            cur.next = list2;
        }
        if (list2 == null) {
            cur.next = list1;
        }
        return dummyNode.next;
    }
}
