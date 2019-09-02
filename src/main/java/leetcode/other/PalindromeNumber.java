package leetcode.other;


/**
 * 题目
 *
 *在不使用额外的内存空间的条件下判断一个整数是否是回文
 * 提示：
 * 负整数可以是回文吗？（比如-1）
 * 如果你在考虑将数字转化为字符串的话，请注意一下不能使用额外空间的限制
 * 你可以将整数翻转。但是，如果你做过题目“Reverse Integer”，
 * 你会知道将整数翻转可能会出现溢出的情况，你怎么处理这个问题？
 * 这道题有更具普遍性的解法。
 */

public class PalindromeNumber {

    public static boolean isPalindrome(int x) {
        if( x < 0 ){
            return false;
        }

        int temp = 1;
        //判断一个整数的最高位是哪一位
        while(temp <= x/10){
            temp *= 10;
        }

        while (x > 0){
            if(x / temp != x % 10){
                return false;
            }
            //去掉最高位
            x = (x % temp) / 10;
            //去掉最低位
            temp /= 100;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(123));

    }

}

/**
 * 思路
 *
 * 判断数字的第一位和最后一位是否相等，不是直接返回false
 */
