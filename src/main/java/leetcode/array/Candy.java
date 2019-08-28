package leetcode.array;

import java.util.Arrays;

/**
 * 有N个小朋友站在一排，每个小朋友都有一个评分
 * 你现在要按以下的规则给孩子们分糖果：
 * 每个小朋友至少要分得一颗糖果
 * 分数高的小朋友要他比旁边得分低的小朋友分得的糖果多
 * 你最少要分发多少颗糖果？
 *
 * There are N children standing in a line. Each child is assigned a rating value.
 * You are giving candies to these children subjected to the following requirements:
 *
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 */

public class Candy {
    public static int candy(int[] ratings) {
        if(ratings == null || ratings.length < 1){
            return 0;
        }

        int[] res = new int[ratings.length + 1];

        Arrays.fill(res, 1);
        int sum = 0;
        for(int i = 1; i < ratings.length; i++){
            if(ratings[i] > ratings[i-1]){
                res[i] = Math.max(res[i], res[i - 1] + 1);
            }
        }

        sum = res[ratings.length - 1];
        for(int j = ratings.length - 2; j >= 0; j--){
            if(ratings[j] > ratings[j + 1]){
                res[j] = Math.max(res[j], res[j+1] + 1);
            }

            sum += res[j];
        }

        return sum;
    }


    /**
     * 优化
     *
     * @param ratings
     */
    public static int candy2(int[] ratings) {
        if(ratings == null || ratings.length < 1){
            return 0;
        }

        int[] res = new int[ratings.length + 1];

        Arrays.fill(res, 1);
        int sum = 0;
        for(int i = 1; i < ratings.length; i++){
            if(ratings[i] > ratings[i-1]){
               res[i] = res[i-1] + 1;
            }
        }

        sum = res[ratings.length - 1];
        for(int j = ratings.length - 2; j >= 0; j--){
            if(ratings[j] > ratings[j + 1]){
                res[j] = Math.max(res[j], res[j+1] + 1);
            }

            sum += res[j];
        }

        return sum;
    }


    public static void main(String[] args) {
        int[] ratings = {4,3,2};
        int[] ratings2 = {1,2,4,3};
        System.out.println(candy(ratings));
        System.out.println(candy2(ratings2));
    }
}


/**
 *解题思路
 *
 * 动态规划求解
 * 从左往右扫一次，后面比前面大的，糖果数+1
 * 再从右往左扫一次，前面比后面大的情况下，还需要比较前面的糖果数是否比后面糖果数加1之后谁大
 *
 * 用sum 在右到左过程中进行糖果数统计
 */