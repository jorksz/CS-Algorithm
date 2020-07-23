package leetcode.graph;

public class IsGraphBipartite {
    //涂颜色使用的颜色，分别是：无色、红色和绿色
    private static final int UNCOLORED = 0;
    private static final int RED = 1;
    private static final int GREEN = 2;
    //用于记录节点颜色
    private int[] color;
    //记录是否二分图
    private boolean valid = true;

    public boolean isBipartite(int[][] graph) {
        //图节点数量
        int n = graph.length;
        color = new int[n];

        for (int i = 0; i < n; i++) {
            //题中没有说明一定是连通图，所以需要每个没有涂色的节点作为起始节点涂颜色
            if (color[i] == UNCOLORED) {
                dfs(i, RED, graph);
            }
        }
        return valid;
    }

    private void dfs(int node, int c, int[][] graph) {
        color[node] = c;
        //这次遍历中当前节点相邻节点应该涂的颜色
        int nc = c == RED ? GREEN : RED;
        //遍历当前节点相邻所有节点
        for (int neighbor : graph[node]) {
            //如果相邻接点还没涂色，则继续深度优先遍历涂色
            if (color[neighbor] == UNCOLORED) {
                dfs(neighbor, nc, graph);
                //判断上面遍历已经确定图不是二分图
                if (!valid) {
                    return;
                }
                //如果相邻节点已经有颜色，并且跟这次遍历本该涂的颜色不一致，说明不是二分图
            } else if (color[neighbor] != nc) {
                valid = false;
                return;
            }
        }
    }
}
