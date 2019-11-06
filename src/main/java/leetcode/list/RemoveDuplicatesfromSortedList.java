package leetcode.list;


import java.util.LinkedHashSet;

/**
 * 题目
 *
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 */

public class RemoveDuplicatesfromSortedList {

    /**
     * 常规迭代解法
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return head;
        }

        ListNode dummy = head;

        while (dummy != null && dummy.next != null){
            if(dummy.val == dummy.next.val){
                dummy.next = dummy.next.next;
            }

            else {
                dummy = dummy.next;
            }
        }

        return head;

    }

    /**
     * 递归解法
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

         head.next = deleteDuplicates2(head.next);

        if(head.val == head.next.val){
            head = head.next;
        }

        return head;
    }
}


/**
 * 迭代的解法，思路很常规，遍历链表判断前后结点是否相同，是的话就跳过，不是就继续遍历
 * 这里题目给的前提是 已经排好序的，这个是很重要的条件
 *
 * 递归解法，LeetCode上有个说法，我觉得很好，大家可以看看，下面是解题思路和这类题的普遍解法
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/comments/
 *
 * 找终止条件：当head指向链表只剩一个元素的时候，自然是不可能重复的，因此return
 * 想想应该返回什么值：应该返回的自然是已经去重的链表的头节点
 * 每一步要做什么：宏观上考虑，此时head.next已经指向一个去重的链表了，
 * 而根据第二步，我应该返回一个去重的链表的头节点。
 * 因此这一步应该做的是判断当前的head和head.next是否相等，如果相等则说明重了，返回head.next，否则返回head
 */