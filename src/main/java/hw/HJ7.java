package hw;

import java.util.Scanner;

public class HJ7 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
       /* String[] splits = input.split("\\.");
        String newDecimal = "0." + splits[1];
        int intNum = Integer.parseInt(splits[0]);
        float f = Float.parseFloat(newDecimal);
        if (f >= 0.5) {
            intNum += 1;
        }
        System.out.println(intNum);*/


        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }
    }
}
