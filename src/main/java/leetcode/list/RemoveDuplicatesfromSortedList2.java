package leetcode.list;


/**
 * 题目
 *
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 */


public class RemoveDuplicatesfromSortedList2 {

    /**
     * 迭代
     * @param head
     * @return
     * 时间复杂度为O（n)
     * 空间复杂度为O（1）
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;

       while (cur != null){

           while (cur.next != null && cur.next.val == pre.next.val){
               cur = cur.next;
           }

           if(pre.next == cur){
               pre = pre.next;
           }
           else {

               pre.next = cur.next;
           }

           cur = cur.next;
       }

        return dummy.next;
    }


    /**
     * 递归
     * @param head
     * @return
     * 时间复杂度为O（n)
     * 空间复杂度为O（1）
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        if(head.next != null && head.val == head.next.val){
            while (head.next!= null && head.next.val == head.val){
                head = head.next;
            }

            return deleteDuplicates2(head.next);
        }
        else {
            head.next = deleteDuplicates2(head.next);
        }

        return head;
    }
}


/**
 *
 * 解题思路
 *
 * 迭代：
 * 使用pre前指针和cur当前指针，当cur.next的值与pre.next的值相同时，cur后移
 * pre.next == cur 判断中间是否有重复元素，没有 pre下移，有就跳过
 * 一般这种还需要操纵头结点的，建个虚拟节点会好的多
 *
 * 递归：
 * 思路和迭代差不多
 */