package leetcode.character;

public class AddStrings {
    public String addStrings(String num1, String num2) {
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        int carry = 0;
        StringBuffer stringBuffer = new StringBuffer();
        while (len1 >= 0 || len2 >= 0 || carry != 0){
            int add1 = len1 >= 0 ? num1.charAt(len1) - '0' : 0;
            int add2 = len2 >= 0 ? num2.charAt(len2) - '0' : 0;
            int res = add1 + add2 + carry;
            stringBuffer.append(res % 10);
            carry = res / 10;
            len1 --;
            len2 --;
        }

        return stringBuffer.reverse().toString();
    }
}
