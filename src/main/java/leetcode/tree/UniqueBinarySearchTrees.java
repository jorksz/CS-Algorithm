package leetcode.tree;

public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        long res = 1;
        for (int i = 0; i < n; i++){
            res = 2 * res * (2*i + 1) / (i + 2);
        }

        return (int)res;
    }
}
