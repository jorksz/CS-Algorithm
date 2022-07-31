package niukeTop101.list;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class BM12SortInList {

    /**
     * 内存超了。。
     * 原因于重新构建链表时，最后节点没置空，导致回成循环链表
     * O（n)
     * @param head
     * @return
     */
    public ListNode sortInList (ListNode head) {
        // write code here
        List<ListNode> listNodes = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            listNodes.add(temp);
            temp = temp.next;
        }
        listNodes.sort(Comparator.comparingInt(o -> o.val));

        ListNode dummy = new ListNode(-1);
        ListNode tempDummy = dummy;
        for (ListNode listNode : listNodes) {
            tempDummy.next = listNode;
            tempDummy = tempDummy.next;
        }
        // 置空，避免循环链表
        tempDummy.next = null;
        return dummy.next;
    }

    public ListNode sortInList2 (ListNode head) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        ListNode temp = head;
        while (temp != null) {
            priorityQueue.add(temp);
            temp = temp.next;
        }

        ListNode dummy = new ListNode(-1);
        ListNode tempDummy = dummy;
        while (!priorityQueue.isEmpty()) {
            tempDummy.next = priorityQueue.poll();
            tempDummy = tempDummy.next;
        }
        tempDummy.next = null;
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] array = {-426572,-406609,724427,-157789,-132713,720732,-39078,-348926,-693458,559374,114739,-748249,428207,-767407,401563,646432,-682870,483610,-608888,94840,749542,359115,131739,935294,347325,80573,-869091,-757897,-860166,-227942,-484068,-170790,-362441,-860466,819197,817675,886101,463504,-100482,496406,-860791};
        ListNode head1 = new ListNode(-1);
        ListNode temp1 = head1;
        for (int j : array) {
            temp1.next = new ListNode(j);
            temp1 = temp1.next;
        }

        BM12SortInList bm12SortInList = new BM12SortInList();
        bm12SortInList.sortInList(head1);

    }
}
