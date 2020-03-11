package leetcode.dp;

/**
 * 题目
 * 将数组分成和相等的三个部分
 * https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum/
 */
public class PartitionArrayIntoThreePartsWithEqualSum {

    public static boolean canThreePartsEqualSum(int[] A) {
        if (A.length == 0 || A == null){
            return false;
        }

        int res = 0;
        for (int i : A){
            res += i;
        }
        if (res % 3 != 0){
            return false;
        }

        int tempSum = 0;
        int part = 0;
        for (int i = 0; i < A.length; i++){
            tempSum += A[i];
            if (tempSum == res /3){
                part ++;
                tempSum = 0;
            }
        }
        return part == 3 || (part > 3 && tempSum == 0);
    }


    public static void main(String[] args) {
        int [] A ={10,-10,10,-10,10,-110,-10,0};
        System.out.print(canThreePartsEqualSum(A));
    }
}
