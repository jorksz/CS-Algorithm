package niukeTop101.str;

public class BM91 {
    public String solve (String str) {
        // write code here
        int len = str.length();
        StringBuilder builder = new StringBuilder();
        for (int i = len - 1; i >= 0; i--) {
            builder.append(str.charAt(i));
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        BM91 bm91 = new BM91();
        String str = "abcd";
        System.out.println(bm91.solve(str));
    }
}
