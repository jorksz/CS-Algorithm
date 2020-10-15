package leetcode.character;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCommonCharacters {
    // 分别对每个字符串进行遍历统计每个字符出现的次数
    // 然后在每个字符串统计完之后，与上个结果进行合并，这里合并只需要取最小值即可，
    // 最小值表示出现的在之前字符串同时出现的次数。
    // 最后再遍历，放入集合中即可。
    public List<String> commonChars(String[] A) {
        int[] res = new int[26];
        Arrays.fill(res, Integer.MAX_VALUE);

        for (String str : A) {
            int[] temp = new int[26];
            for (int i = 0; i < str.length(); i++) {
                temp[str.charAt(i) - 'a'] ++;
            }

            for (int i = 0; i < 26; i++) {
                res[i] = Math.min(res[i], temp[i]);
            }
        }

        List<String> resLists = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < res[i]; j++) {
                resLists.add(String.valueOf((char) (i + 'a')));
            }
        }

        return resLists;
    }

    public static void main(String[] args) {
        String[] strings = {"cool","lock","cook"};
        FindCommonCharacters findCommonCharacters = new FindCommonCharacters();
        System.out.println(findCommonCharacters.commonChars(strings));
    }
}
