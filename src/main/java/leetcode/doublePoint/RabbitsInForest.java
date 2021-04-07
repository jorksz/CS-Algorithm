package leetcode.doublePoint;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lijt
 */
public class RabbitsInForest {

    private int count = 0;
    public int numRabbits(int[] answers) {
        if (answers == null || answers.length == 0) {
            return 0;
        }
        // 看见次数 -> 看见次数出现的次数
        Map<Integer, Integer> counts = new HashMap<>(1000);
        for (int answer : answers) {
            counts.put(answer, counts.getOrDefault(answer, 0) + 1);
        }

        // (k + v ) 为了向上取整， 如4/5 向上取整 (4 + 5 -1) / 5
        counts.forEach((k,v) -> count +=((k + v) / (k + 1) * (k + 1)));

        return count;
    }

    public int numRabbits2(int[] answers) {

        // 题目限定了大小，这里也可以不用map来进行解决
        int[] res = new int[1000];
        int count = 0;
        for (int answer : answers) {
            // 有同伴
            if (res[answer] > 0) {
                res[answer] --;
            }else {
                // 没同伴的话，在报数的基础上 + 1
                res[answer] = answer;
                count += answer + 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        RabbitsInForest rabbitsInForest = new RabbitsInForest();
        int[] testCase = {0,0,1,1,1};
        System.out.println(rabbitsInForest.numRabbits(testCase));
        System.out.println(rabbitsInForest.numRabbits2(testCase));
    }
}
