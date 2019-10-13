package leetcode.list;


/**
 * 题目
 *
 * 给定两个代表非负数的链表，数字在链表中是反向存储的（链表头结点处的数字是个位数，第二个结点上的数字是百位数...），
 * 求这个两个数的和，结果也用链表表示。
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出： 7 -> 0 -> 8
 */

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;

        int carry = 0;
        int sum = 0;
        while (l1 != null || l2 != null){

            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            sum = num1 + num2 + carry;
            carry = sum >= 10 ? 1: 0;

            pre.next = new ListNode(sum % 10);

            pre = pre.next;

            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
        }

        if(carry == 1){
            pre.next = new ListNode(carry);
        }

        return dummy.next;
    }
}

/**
 * 链表遍历，需要一个进位标记，
 */
