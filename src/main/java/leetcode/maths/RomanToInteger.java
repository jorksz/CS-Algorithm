package leetcode.maths;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lijt
 */
public class RomanToInteger {
    private static Map<Character, Integer> romanSymbol = new HashMap<>();
    static {
        romanSymbol.put('I', 1);
        romanSymbol.put('V', 5);
        romanSymbol.put('X', 10);
        romanSymbol.put('L', 50);
        romanSymbol.put('C', 100);
        romanSymbol.put('D', 500);
        romanSymbol.put('M', 1000);
    }
    public int romanToInt(String s) {
        if (s == null) {
            return 0;
        }

        char[] chars = s.toCharArray();
        int numRes = 0;
        for (int i = 0; i < chars.length; i++) {
            int num = romanSymbol.get(chars[i]);
            if (i + 1 < chars.length && num < romanSymbol.get(chars[i+1])) {
                numRes -= romanSymbol.get(chars[i]);
            } else {
                numRes += romanSymbol.get(chars[i]);
            }
        }

        return numRes;
    }

    public static void main(String[] args) {
        RomanToInteger romanToInteger = new RomanToInteger();
        String testCase1 = "III";
        System.out.println(romanToInteger.romanToInt(testCase1));

        String testCase2 = "IV";
        System.out.println(romanToInteger.romanToInt(testCase2));
    }
}
