package leetcode.graph;


import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    List<List<Integer>> res = new ArrayList<>();
    //Deque<Integer> deque = new ArrayDeque<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        //deque.addLast(0);
        dfs2(graph, new ArrayList<>(), 0, graph.length - 1);
        return res;
    }

  /*  private void dfs(int[][] graph, int index, int n) {
        if (index == n) {
            res.add(new ArrayList<>(deque));
        }

        for (int value : graph[index]) {
            deque.addLast(value);
            dfs(graph, value, n);
            deque.removeLast();
        }
    }*/

    private void dfs2(int[][] graph, List<Integer> tempList, int index, int n) {
        if (index == n) {
            tempList.add(index);
            res.add(new ArrayList<>(tempList));
            tempList.remove(tempList.size() - 1);
            return;
        }
        // 避免丢 0 这情况
        tempList.add(index);
        for (int value : graph[index]) {
            dfs2(graph, tempList, value, n);
        }
        tempList.remove(tempList.size() - 1);
    }

    public static void main(String[] args) {
        int[][] graph = {{1,2},{3},{3},{}};
        AllPathsFromSourceToTarget target = new AllPathsFromSourceToTarget();
        System.out.println(target.allPathsSourceTarget(graph));
    }

}
