package leetcode.character;

public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        int len = s.length();
        int last = 0;
        int count = 0;
        int res = 0;
        while (count < len){
            char c = s.charAt(count);
            int tempCount = 0;
            while (count < len && s.charAt(count) == c){
                count++;
                tempCount++;
            }
            res += Math.min(tempCount, last);
            last = tempCount;
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
