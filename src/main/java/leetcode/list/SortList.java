package leetcode.list;

/**
 * 题目
 * 在O(n log n)的时间内使用常数级空间复杂度对链表进行排序。
 */
public class SortList {

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode first = head;
        ListNode last = head;

        while(last.next != null && last.next.next != null){
            first = first.next;
            last  = last.next.next;
        }

        ListNode lastPartList = first.next;
        first.next = null;
        ListNode firstPartList = head;

        ListNode left = sortList(firstPartList);
        ListNode right = sortList(lastPartList);

        return sortMergeList(left, right);
    }

    private ListNode sortMergeList(ListNode left, ListNode right) {

        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        while (left != null && right != null){
            if(left.val < right.val){
                temp.next = left;
                left = left.next;
            }
            else {
                temp.next = right;
                right = right.next;
            }

            temp = temp.next;
        }

        if(left != null){
            temp.next = left;
        }

        if(right != null ){
            temp.next = right;
        }

        return dummy.next;
    }
}

/**
 *解题思路
 *
 * 题目要求时间复杂度为O(nlogn)，可想而知，这里需要排序算法，排序符合要求的有快排，堆排， 归并排序
 *
 * 通过快慢指针将链表分为两个部分，依次递归左右部分，最后merge
 *
 */