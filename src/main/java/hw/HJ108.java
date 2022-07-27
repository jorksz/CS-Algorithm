package hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ108 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        String input = br.readLine();
        String[] inputs = input.split(" ");
        int a = Integer.parseInt(inputs[0]);
        int b = Integer.parseInt(inputs[1]);
        System.out.println(gcb(a, b, a));
    }

    /**
     * 公倍数的概念就是同时可以整除两个数。
     * 所以只要一个数逐渐累加自身到可以整除另一个数时就是既可以整除自己也可以整除另一个数，此时结果就是要得到的公倍数
     * @param a
     * @param b
     * @param c
     * @return
     */
    public static int gcb(int a, int b ,int c) {
        if(a%b == 0) {
            return a;
        }
        return gcb(a + c, b, c);
    }
}
