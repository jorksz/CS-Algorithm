package hw;

import java.util.Scanner;

public class HJ1 {

    public  static void  main(String [] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        System.out.println(getResult(word));
    }

    public static int getResult(String word) {
        String[] words = word.split(" ");
        return words[words.length - 1].length();
    }
}
