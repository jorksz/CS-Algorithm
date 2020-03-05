package leetcode.dp;

/**
 * 分糖果Ⅱ
 * https://leetcode-cn.com/problems/distribute-candies-to-people/
 */
public class DistributeCandiestoPeople {

    /**
     * 暴力遍历
     * @param candies
     * @param num_people
     * @return
     */
    public static int[] distributeCandies(int candies, int num_people) {
        if (candies == 0 || num_people == 0){
            return new int[0];
        }
        int[] dp = new int[num_people];
        int i = 0;
        while (candies != 0){
            //min 作用就是当最后一次糖果不够发的时候，全给最后一位小孩
            dp[i % num_people] += Math.min(i+1, candies);
            candies -= Math.min(i+1, candies);
            i++;
        }
        return dp;
    }

    public static void main(String[] args) {
        for (int i :distributeCandies(6,3)){
            System.out.print(i+" ");
        }
    }
}


/**
 * 其他解法：
 * https://leetcode-cn.com/problems/distribute-candies-to-people/solution/fen-tang-guo-ii-by-leetcode-solution/
 */