package hw;

import java.util.Scanner;

public class PressurizedBottle {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            if (a == 0) {
                return;
            }
            System.out.println(getBottle(a));
        }
    }

    public static int getBottle(int n) {
        if (n < 2) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }

        return n / 3 + getBottle(n % 3 + n / 3);
    }
}
