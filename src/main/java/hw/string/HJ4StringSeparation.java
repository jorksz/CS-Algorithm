package hw.string;

import java.util.Scanner;

public class HJ4StringSeparation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String line = in.nextLine();
            if (line != null && !line.equals("")) {

                while (line.length() > 0) {
                    if (line.length() > 8) {
                        String printStr = line.substring(0, 8);
                        System.out.println(printStr);
                        line = line.substring(8);
                    } else {
                        String addZero = line + "00000000";
                        System.out.println(addZero.substring(0, 8));
                        break;
                    }
                }
            }
        }
    }
}
