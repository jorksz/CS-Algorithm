package leetcode.character;


import java.util.Scanner;

/**
 * 题目
 *
 * 请将给出的整数转化为罗马数字
 * 保证输入数字的范围在1 到 3999之间。
 */

public class IntegerToRoman {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer str = sc.nextInt();
        System.out.println(intToRoman(str));
    }

    public static String intToRoman(int num) {

        int[] nums = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] strings = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < nums.length; i++){
            while(num >= nums[i]){
                num -= nums[i];
                stringBuilder.append(strings[i]);
            }
        }

        return stringBuilder.toString();

    }

}

/**
 * 解题思路
 *
 * 两个数组做好映射，当目标数字 >= 当前数字 ，循环递减 即可。  主要还是做好映射
 */
