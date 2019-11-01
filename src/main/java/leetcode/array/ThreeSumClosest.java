package leetcode.array;


/**
 * 给出含有n个整数的数组s，找出s中和加起来的和最接近给定的目标值的三个整数。
 * 返回这三个整数的和。你可以假设每个输入都只有唯一解。
 * 例如，给定的整数 S = {-1 2 1 -4}, 目标值 = 1.↵↵   最接近目标值的和为 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {

    public static int threeSumClosest(int[] num, int target) {
        if(num == null || num.length == 0){
            return 0;
        }

        int sum = 0;
        int temp = 0;
        int res = 0;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < num.length; i++){
            for(int j = i+1; j < num.length; j++){
                for(int k = j + 1; k < num.length; k++){

                    sum = num[i] + num[j] + num[k];

                    temp = Math.abs(sum - target);

                    if(temp == 0){
                        return sum;
                    }
                    if(temp < min){
                        min = temp;
                        res = sum;
                    }
                }
            }
        }

        return res;
    }


    public  int threeSumClosest2(int[] num, int target) {
        if (num == null || num.length == 0) {
            return 0;
        }

        return 0;

    }




    public static void main(String[] args) {
        int[] sum = {-1,1,2,3};
        int target = 2;
        System.out.println(threeSumClosest(sum,target));
    }




}
