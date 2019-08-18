package leetcode.list;


/**
 * 题目
 *
 * 将两个有序的链表合并为一个新链表，要求新的链表是通过拼接两个链表的节点来生成的。
 *
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists
 */

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }

        if(l2 == null){
            return l1;
        }

        ListNode newList = new ListNode(0);
        ListNode duumy = newList;

        while(l1 != null && l2 != null){
            if(l1.val >= l2.val){
                duumy.next = l2;
                l2 = l2.next;
            }
            else {
                duumy.next = l1;
                l1 = l1.next;
            }

            duumy = duumy.next;
        }

        if(l1 != null){
            duumy.next = l1;
        }

        if (l2 != null){
            duumy.next = l2;
        }

        return newList.next;
    }
}

/**
 * 解题思路
 *
 *
 * 新链表的第一个结点问题，由于一般情况下第一个结点都需要特殊处理，
 * 比较实用的解决办法是在第一个结点前增加一个虚拟的头结点(例如下面的duumy)，
 * 讲实际的第一个结点一般化。最后输出的时候输出这个虚拟结点的下一个结点就OK
 */