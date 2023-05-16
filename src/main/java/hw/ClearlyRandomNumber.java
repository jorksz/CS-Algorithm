package hw;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;

public class ClearlyRandomNumber {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        HashSet<Integer> set = new HashSet<>();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            set.add(in.nextInt());
        }
        set.stream().sorted(Comparator.comparingInt(o -> o)).forEach(System.out::println);
    }
}
