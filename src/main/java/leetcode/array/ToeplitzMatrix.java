package leetcode.array;

/**
 * @author lijt
 */
public class ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 1; i < row; i++) {

            for (int j = 1; j < col; j++) {

                if (matrix[i][j] != matrix[i-1][j-1]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4}, {5,1,2,3}, {9,5,1,2}};
        ToeplitzMatrix toeplitzMatrix = new ToeplitzMatrix();
        System.out.println(toeplitzMatrix.isToeplitzMatrix(matrix));
    }
}
