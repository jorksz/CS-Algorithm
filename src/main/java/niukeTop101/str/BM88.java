package niukeTop101.str;

public class BM88 {

    public boolean judge (String str) {
        // write code here
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "absba";
        BM88 bm88 = new BM88();
        System.out.println(bm88.judge(str));
    }
}
