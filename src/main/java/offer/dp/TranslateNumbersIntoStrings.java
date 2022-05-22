package offer.dp;

/**
 * 剑指 Offer 46. 把数字翻译成字符串
 */
public class TranslateNumbersIntoStrings {

    public int translateNum(int num) {
        String str = String.valueOf(num);

        int a = 1;
        int b = 1;
        for (int i = 2; i <= str.length(); i++) {
              String c = str.substring(i-2, i);
              int temp;
              if (c.compareTo("10") >= 0 && c.compareTo("25") <= 0) {
                  temp = a + b;
              } else {
                  temp = b;
              }
              a = b;
              b = temp;
        }

        return b;
    }

    public static void main(String[] args) {
        TranslateNumbersIntoStrings translateNumbersIntoStrings = new TranslateNumbersIntoStrings();
        System.out.println(translateNumbersIntoStrings.translateNum(25));
    }
}
