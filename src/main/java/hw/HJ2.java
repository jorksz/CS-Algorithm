package hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class HJ2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String ch = br.readLine();
        System.out.println(count(str, ch));
    }

    public static int count(String str, String input) {
        Map<Character, Integer> res = new HashMap<>();
        String upperStr = str.toUpperCase();
        for (char c : upperStr.toCharArray()) {

          res.put(c, res.getOrDefault(c, 0) + 1);
        }
        String upperInput = input.toUpperCase();
        return res.getOrDefault(upperInput.charAt(0), 0);
    }
}
