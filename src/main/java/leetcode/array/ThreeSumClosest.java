package leetcode.array;


import java.util.Arrays;

/**
 * 给出含有n个整数的数组s，找出s中和加起来的和最接近给定的目标值的三个整数。
 * 返回这三个整数的和。你可以假设每个输入都只有唯一解。
 * 例如，给定的整数 S = {-1 2 1 -4}, 目标值 = 1.↵↵   最接近目标值的和为 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int sum = 0;
        int temp = 0;
        int res = 0;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                for(int k = j + 1; k < nums.length; k++){

                    sum = nums[i] + nums[j] + nums[k];

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


    public static int threeSumClosest2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {

            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int current = nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int tempSumResult = current + nums[left] + nums[right];
                if (tempSumResult == target) {
                    return tempSumResult;
                }

                if (Math.abs(tempSumResult - target) < Math.abs(result - target)) {
                    result = tempSumResult;
                }

                if (tempSumResult > target) {
                    while (left < right && nums[right] == nums[right-1]) {
                        right--;
                    }
                    right--;
                } else {
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left++;
                }
            }
        }

        return result;

    }




    public static void main(String[] args) {
        int[] sum = {-1,1,2,3};
        int target = 2;
        System.out.println(threeSumClosest2(sum,target));

        int[] sum2 = {0,0,0,0};
        int target1 = 1;
        System.out.println(threeSumClosest2(sum2,target1));

        int[] sum3 = {-1,2,1,-4};
        int target2 = 1;
        System.out.println(threeSumClosest2(sum3,target2));
    }




}
