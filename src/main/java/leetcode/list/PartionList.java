package leetcode.list;

/**
 * 题目
 *
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 */
public class PartionList {

    public ListNode partition(ListNode head, int x) {

        if(head == null){
            return head;
        }

        ListNode dummyFirst = new ListNode(0);
        ListNode first = dummyFirst;
        ListNode dummyLast = new ListNode(0);
        ListNode last = dummyLast;

        while (head != null){

            if(head.val < x){
                first.next = head;
                first = first.next;
            }
            else {
                last.next = head;
                last = last.next;
            }

            head = head.next;
        }

        //置null,防止最后一个结点加入last链表中
        last.next = null;
        first.next = dummyLast.next;


        return dummyFirst.next;
    }
}

/**
 * 解题思路
 *
 * 将链表分为两个链表，一个链表比X小，一个比X大，最后再链接在一起
 *
 * 需要注意将last.next = null,不然last链表最后总是添加上了原链表最后一个值
 */