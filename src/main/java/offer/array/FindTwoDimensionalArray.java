package offer.array;


/**
 * 题目 - 二维数组的查找
 *
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class FindTwoDimensionalArray {

    public static boolean Find(int target, int [][] array) {
        if(target <= 0 || array == null){
            return false;
        }

        int row = 0;
        int col = array[0].length - 1;

        //从右上角开始遍历比较
        while(row <= array.length - 1 && col >= 0){
            if(array[row][col] == target){
                return true;
            }
            //往下搜索
            else if(array[row][col] < target){
                row ++;
            }
            //往左搜索
            else {
                col --;
            }
        }

        return false;
    }
}

/**
 * 解题思路
 *
 * 常规方法也就是全数组扫描，复杂度为0（n^2)
 *
 * 这里可以通过从右上角开始遍历，利用row,col指针，当前值小于目标值就往下走，反正忘左走，复杂度为0（n)，空间上为O(1)
 */
