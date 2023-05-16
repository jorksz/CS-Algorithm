package hw.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HJ5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String hexString = in.nextLine();
        hexString = hexString.substring(2);
        Map<Character, Integer> map = initMap();
        int result = 0;
        for (int i = hexString.length() - 1; i >= 0; i--) {
             Character c = hexString.charAt(i);
            if (map.containsKey(c)) {
                result += getValue(map.get(c),  hexString.length() - i);
            } else {
                result += getValue(Integer.parseInt(c.toString()),hexString.length() - i);
            }
        }

        System.out.println(result);
    }

    public static Map<Character, Integer> initMap() {
        Map<Character, Integer> hexMap = new HashMap<>();
        hexMap.put('A', 10);
        hexMap.put('B', 11);
        hexMap.put('C', 12);
        hexMap.put('D', 13);
        hexMap.put('E', 14);
        hexMap.put('F', 15);
        return hexMap;
    }

    public static int getValue (int res, int loopCount) {
        int value = 1;
        for (int i = 1; i < loopCount; i++) {
            value = value * 16;
        }

        return res * value;
    }
}
