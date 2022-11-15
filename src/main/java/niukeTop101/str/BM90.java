package niukeTop101.str;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BM90 {

    /**
     * 不要求T在S出现的顺序。。。
     *
     * @param S
     * @param T
     * @return
     */
    public String minWindow (String S, String T) {
        // write code here  

        int sLen = S.length() + 1;
        // 字母范围最大到 123
        int[] hash = new int[123];
        for (int i = 0; i < T.length(); i++) {
            // 考虑到T里边字母会重复的情况，不直接赋值-1
            hash[T.charAt(i)] -= 1;
        }
        // 窗口左右Index
        int left = -1;
        int right = -1;
        int slow = 0;
        int fast = 0;
        for (; fast < S.length(); fast++) {
            char sCh = S.charAt(fast);
            hash[sCh]++;
            while (check(hash)) {
                if (sLen > fast - slow + 1) {
                    // 这时候窗口长度就是Slen
                    sLen = fast - slow + 1;
                    // 记录此时窗口 Index,只变slow, fast
                    left = slow;
                    right = fast;
                }
                hash[S.charAt(slow)]--;
                slow++;
            }
        }

        return left == -1 ? "" : S.substring(left, right + 1);
    }

    private boolean check(int[] hash) {
        for (int j : hash) {
            if (j < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "XDOYEZODEYXNZ";
        String z = "XYZ";
        BM90 bm90 = new BM90();
        System.out.println(bm90.minWindow(s, z));
    }
}
