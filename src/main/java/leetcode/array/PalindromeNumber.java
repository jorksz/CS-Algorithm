package leetcode.array;


/**
 * 题目
 * 判断一个整数是否是回文数。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {

        String str = String.valueOf(x);

        StringBuilder stringBuilder = new StringBuilder();
        String str2 = stringBuilder.append(str).reverse().toString();
        return str.equals(str2);
    }

    public boolean isPalindrome2(int x) {
        if(x < 0 || (x % 10 == 0 && x != 0)){
            return false;
        }

        int reverseNum = 0;

        while (x > reverseNum){
            reverseNum = x % 10 + reverseNum*10;
            x /= 10;
        }

        return x == reverseNum || x == reverseNum / 10;
    }

    public static void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        System.out.println(palindromeNumber.isPalindrome(122));
        System.out.println(palindromeNumber.isPalindrome2(122));
    }
}


/**
 *  解题思路
 *
 *  第一种方法，就是字符串反转比较，思路很简单，空间复杂度比较高
 *
 *  第二种，当x<0，反转都是false，如果是回文的话，那么只需要反转一半的数字即可得出是否是回文
 *  那么如何判断是否反转了一半的数字呢，就是当原数字小于等于反转的数字的时候即可判断反转了一半了
 *  最后x == reverseNum /10 这步是奇数情况下的，因为最中间那个数字反转都是它本身，可以剔除掉不影响结果
 */