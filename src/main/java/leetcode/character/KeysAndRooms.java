package leetcode.character;

import java.util.List;

public class KeysAndRooms {
    boolean[] visit;
    int num;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        visit = new boolean[n];
        dfs(rooms, 0);
        return num == n;
    }

    private void dfs(List<List<Integer>> rooms, int i) {
        visit[i] = true;
        num++;
        for (int j : rooms.get(i)){
            if (!visit[j]){
                dfs(rooms, j);
            }
        }

    }
}
