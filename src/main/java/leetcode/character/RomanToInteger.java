package leetcode.character;


import java.util.HashMap;
import java.util.Scanner;

/**
 *请将给出的罗马数字转化为整数
 * 保证输入的数字范围在1 到 3999之间。
 */

public class RomanToInteger {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(romanToInt(str));
    }



    public static int romanToInt(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('I',1);
        hashMap.put('V',5);
        hashMap.put('X',10);
        hashMap.put('L',50);
        hashMap.put('C',100);
        hashMap.put('D',500);
        hashMap.put('M',1000);

        int len = s.length();
        int res = hashMap.get(s.charAt(len - 1));
        for(int i = len - 2; i >= 0; i--){
            if(hashMap.get(s.charAt(i)) >= hashMap.get(s.charAt(i + 1))){
                res += hashMap.get(s.charAt(i));
            }
            else {
                res -= hashMap.get(s.charAt(i));
            }
        }

        return res;
    }


}


/**
 *解题思路
 *
 * 利用map做一个符号映射
 *
 * 如果字符串左边的字符代表的数字比右边大，如VII 就做累加
 * 如果右边大于左边 如IV 就做减法
 */