package leetcode.list;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


/**
 * 题目
 *
 * 合并k个已排序的链表并将其作为一个已排序的链表返回。分析并描述其复杂度。
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */
public class MergeKSortedLists {

    /**
     * 归并排序 O（nlogn)
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists == null || lists.size() == 0){
            return null;
        }

        return helper(lists, 0, lists.size() - 1);
    }

    private ListNode helper(ArrayList<ListNode> lists, int left, int right) {
        if(left < right){
            int mid = (left + right) / 2;

            return merge(helper(lists,left, mid ), helper(lists, mid + 1, right));
        }
        return lists.get(left);
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        dummy.next = head1;
        ListNode cur = dummy;
        while(head1 != null && head2 != null){
            if(head1.val < head2.val){
                head1 = head1.next;
            }

            else{
                ListNode temp = head2.next;
                cur.next = head2;
                head2.next = head1;
                head2 = temp;
            }

            cur = cur.next;
        }

        if(head2 != null){
            cur.next = head2;
        }

        return dummy.next;
    }


    /**
     * 堆排序 O(nlogn)
     */
    public ListNode mergeKLists2(ListNode[] lists) {

        PriorityQueue<ListNode> res = new PriorityQueue<ListNode>(10, Comparator.comparingInt(o -> o.val));

        for(ListNode node : lists){
            if(node != null){
                res.offer(node);
            }
        }

        ListNode cur = null;
        ListNode pre = cur;

        while(!res.isEmpty()){
            ListNode temp = res.poll();
            if(cur == null){
                cur = temp;
                pre = cur;
            }
            else {
                pre.next = temp;

            }
            pre = temp;
            if(temp.next != null){
                res.offer(temp.next);
            }
        }

        return cur;
    }

}


/**
 *归并思路
 * 先将K集合的链表拆开2部分，分别对这两半进行拆开，然后进行链表合并，最后再合并为一个小到大的链表
 *
 * 堆思路
 *  利用PriorityQueue 声明最小堆，每次从堆顶取到的元素都是最小的，然后将他添加到新链表里即可，然后继续添加下一个节点，
 *  这里添加下一个节点进去PriorityQueue里面时，堆也会自行进行调整，所以下次取到的还是最小值。
 */

