package leetcode.find;


/**
 * 题目
 *
 * 给出一个有序的数组和一个目标值，如果数组中存在该目标值，则返回该目标值的下标。
 * 如果数组中不存在该目标值，则返回如果将该目标值插入这个数组应该插入的位置的下标
 * 假设数组中没有重复项。
 * 下面给出几个样例：
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 */
public class SearchInsertPosition {

    public static int searchInsert(int[] A, int target) {
        if(A == null || A.length == 0){
            return 0;
        }

        int left = 0;
        int right = A.length - 1;

        while(left <= right){
            int mid = (left + right) / 2;
            if(A[mid] == target){
                return mid;
            }
            else if(A[mid] < target){
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return left ;
    }

    public static void main(String[] args) {
        int[] A = {1,3,5,6};
        System.out.println(searchInsert(A,0));
    }
}

/**
 * 简单的折半查找
 * 没找到返回left指针即可
 */