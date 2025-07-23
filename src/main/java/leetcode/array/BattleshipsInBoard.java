package leetcode.array;

public class BattleshipsInBoard {

    public int countBattleships(char[][] board) {
        if (board == null) {
            return 0;
        }
        boolean[] visited = new boolean[board.length * board[0].length];
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    count++;
                    int index = i * board[0].length + j;
                    visited[index] = true;
                }

                if (i > 0 && j > 0) {
                    int down = (i - 1) * board[0].length + j;
                    int up = (i + 1) * board[0].length + j;
                    int left = i * board[0].length + j - 1;
                    int right = i * board[0].length + j + 1;
                    if (visited[down] || visited[up] || visited[left] || visited[right]) {
                        count --;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        char[][] board = new char[3][4];
    }
}
