package leetcode.character;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MovableTypePrinting {



    public int numTilePossibilities2(String tiles) {
        Map<Character, Integer> count = new HashMap<>();
        for (char t : tiles.toCharArray()) {
            count.put(t, count.getOrDefault(t, 0) + 1);
        }
        Set<Character> tile = new HashSet<>(count.keySet());
        return dfs(tiles.length(), count, tile) - 1;
    }

    private int dfs(int i, Map<Character, Integer> count, Set<Character> tile) {
        if (i == 0) {
            return 1;
        }
        int res = 1;
        for (char t : tile) {
            if (count.get(t) > 0) {
                count.put(t, count.get(t) - 1);
                res += dfs(i - 1, count, tile);
                count.put(t, count.get(t) + 1);
            }
        }
        return res;
    }

    public int numTilePossibilities(String tiles) {
        Map<Character, Integer> map = new HashMap<>();
        Set<Character> chars = new HashSet<>();
        for (char c : tiles.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            chars.add(c);
        }
        return dfs(map, chars, tiles.length()) - 1;
    }

    public int dfs(Map<Character, Integer> map, Set<Character> chars, int loopFlag) {
        if (loopFlag == 0) {
            return 1;
        }
        int res = 1;
        for (Character character: chars) {
            if (map.get(character) > 0) {
                map.put(character, map.get(character) - 1);
                res += dfs(map, chars, loopFlag - 1);
                map.put(character, map.get(character) + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MovableTypePrinting movableTypePrinting = new MovableTypePrinting();
        String titles = "AAB";
        System.out.println(movableTypePrinting.numTilePossibilities(titles));
    }
}
