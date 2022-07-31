package hw;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class HJ3 {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        Set<Integer> integerSet = new HashSet<>();
        for (int i = 0; i < count; i++) {
            integerSet.add(scanner.nextInt());
        }
        List<Integer> res = integerSet.stream().sorted(Comparator.comparingInt(o -> o)).collect(Collectors.toList());
        res.forEach(System.out::println);
    }

}
