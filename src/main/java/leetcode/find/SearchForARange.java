package leetcode.find;


/**
 * 题目
 *
 * 给出一个有序数组，请在数组中找出目标值的起始位置和结束位置
 * 你的算法的时间复杂度应该在O(log n)之内
 * 如果数组中不存在目标，返回[-1, -1].
 * 例如：
 * 给出的数组是[5, 7, 7, 8, 8, 10]，目标值是8,
 * 返回[3, 4].
 */

public class SearchForARange {

    public static int[] searchRange(int[] A, int target) {
        int[] res = {-1,-1};
        if(A.length < 1 || A == null){
            return res;
        }

        int ll = 0;
        int lr = A.length - 1;

        while(ll <= lr){
            int lm = (ll + lr) / 2;
            if(A[lm] < target){
                ll = lm + 1;
            }

            else {
                lr = lm - 1;
            }
        }

        int rl = 0;
        int rr = A.length - 1;
        while(rl <= rr){
            int rm = (rl + rr) / 2;
            if(A[rm] <= target){
                rl = rm + 1;
            }

            else {
                rr = rm - 1;
            }
        }

        if(ll <= rr){
            res[0] = ll;
            res[1] = rr;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] A ={1};
        int[] res = searchRange(A, 0);
        for(int i : res){
            System.out.println(i);
        }
    }
}

/**
 *解题思路
 *
 * 两次折半排序，如果我们不寻找那个元素先，而是直接相等的时候也向一个方向继续夹逼，
 * 如果向右夹逼，最后就会停在右边界，而向左夹逼则会停在左边界，如此用停下来的两个边界就可以知道结果了
 */