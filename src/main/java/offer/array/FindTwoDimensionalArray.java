package offer.array;

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
