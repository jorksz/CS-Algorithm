package leetcode.find;

import java.util.ArrayList;
import java.util.List;


/**
 * N-皇后问题
 *
 */
public class NQueue {

    public List<List<String>> solveNQueens(int n) {
        if (n < 1){
            return new ArrayList<>();
        }
        List<List<String>> res = new ArrayList<>();
        helper(n, 0, res, new int[n]);
        return res;
    }

    private void helper(int n, int row, List<List<String>> res, int[] colForRow) {
        String[] strings = new String[n];
        //如果当前行和n相等
        if(row == n){
            List<String> temp = new ArrayList<>();
            for(int i = 0; i < n; i++){
                StringBuilder stringBuilder = new StringBuilder();

                for(int j = 0; j < n; j++){
                    //如果当前列与记录的列相等，那么将放置一个皇后，否则放置.
                    if(colForRow[i] == j){
                        stringBuilder.append('Q');
                    }
                    else{
                        stringBuilder.append('.');
                    }

                }
                temp.add(stringBuilder.toString());
            }
            res.add(temp);
            return;
        }

        //循环递归处理子问题
        for(int i = 0; i < n; i++){
            //我们是用一维数组存储皇后在哪一列，理论上我们是要把皇后放在某一列，然后递归结束把它拿走
            // 现在因为是用一个数字来表示哪一列上是皇后，在循环下一层就会columnForRow[row] = i;
            // 相当于把皇后拿走，然后放在第i列了哈
            colForRow[row] = i;
            //如果不发生冲突，走下一行
            if(vilid(colForRow, row)){
                helper(n, row+1,res,colForRow);
            }
        }

    }

    private boolean vilid(int[] colForRow, int row) {
        for(int i = 0; i < row; i++){
            //列是否相等 或者 对角线是否相等，相等就发生冲突返回false
            if(colForRow[i] == colForRow[row] || Math.abs(colForRow[i] - colForRow[row]) == (row - i)){
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        NQueue nQueue = new NQueue();
        List<List<String>> res = nQueue.solveNQueens(5);
    }
}

/**
 *
 * 主要思想就是一句话：用一个循环递归处理子问题。
 * 这个问题中，在每一层递归函数中，我们用一个循环把一个皇后填入对应行的某一列中，
 * 如果当前棋盘合法，我们就递归处理先一行，找到正确的棋盘我们就存储到结果集里面。
 * 这种题目都是使用这个套路，就是用一个循环去枚举当前所有情况，然后把元素加入，递归，再把元素移除，
 * 这道题目中不用移除的原因是我们用一个一维数组去存皇后在对应行的哪一列，因为一行只能有一个皇后，
 * 如果二维数组，那么就需要把那一行那一列在递归结束后设回没有皇后，所以道理是一样的。
 * 这道题最后一个细节就是怎么实现检查当前棋盘合法性的问题，
 * 因为除了刚加进来的那个皇后，前面都是合法的，我们只需要检查当前行和前面行是否冲突即可。
 * 检查是否同列很简单，检查对角线就是行的差和列的差的绝对值不要相等就可以。
 *
 * cover by https://blog.csdn.net/linhuanmars/article/details/20667175#commentBox
 */