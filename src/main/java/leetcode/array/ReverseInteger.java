package leetcode.array;


import java.util.Stack;

/**
 * 题目
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 */

public class ReverseInteger {

    /**
     * Int->String,String->Int，复杂度过高
     * @param x
     * @return
     */
    public int reverse(int x) {
        Stack<Character> stack = new Stack<>();

        String str = String.valueOf(x);
        char[] chars = str.toCharArray();
        int flag = 0;
        if (chars[0] == '-' || chars[0] == '+') {
            flag = 1;

        }
        for( int i = flag; i < chars.length; i++){
            stack.push(chars[i]);
        }

        StringBuilder stringBuilder = new StringBuilder();
        if(flag == 1){
            stringBuilder.append(chars[0]);
        }

        while (!stack.isEmpty()){
            stringBuilder.append(stack.pop());
        }

        long res = Long.valueOf(stringBuilder.toString());

        if(res >= Integer.MAX_VALUE ||res <= Integer.MIN_VALUE){
            return 0;
        }

        return (int) res;

    }


    /**
     * 数学的解题思路
     * @param x
     * @return
     */
    public int reverse2(int x) {
        int res = 0;

        while (x != 0){
            int pop = x % 10;
            if(res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && pop > 7)){
                return 0;
            }
            if(res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && pop < -8)){
                return 0;
            }

            res = res*10+pop;
            x /= 10;
        }

        return res;
    }

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverse2(900000));
        System.out.println(Integer.valueOf(001));
    }

}

/**
 * 通过数学来进行求解
 *
 * 通过循环将数字x的每一位拆开，在计算新值时每一步都判断是否溢出。
 * 溢出条件有两个，一个是大于整数最大值MAX_VALUE，另一个是小于整数最小值MIN_VALUE，
 * 设当前计算结果为res，下一位为pop。
 * 从res * 10 + pop > MAX_VALUE这个溢出条件来看
 * 当出现 res > MAX_VALUE / 10 且 还有pop需要添加 时，则一定溢出
 * 当出现 res == MAX_VALUE / 10 且 pop > 7 时，则一定溢出，7是2^31 - 1的个位数
 * 从res * 10 + pop < MIN_VALUE这个溢出条件来看
 * 当出现 res < MIN_VALUE / 10 且 还有pop需要添加 时，则一定溢出
 * 当出现 res == MIN_VALUE / 10 且 pop < -8 时，则一定溢出，8是-2^31的个位数
 *
 */