package leetcode.array;

import leetcode.character.PalindromicSubstrings;

import java.util.Stack;

public class BackspaceStringCompare {
    // 利用一个O(n)的额外空间来存储字符
    // 遍历字符串，遇到 ‘#’ 字符则删除额外空间最后加进去的某个字符，这里有个细节就是如果
    // 第一个字符就是 ‘#' ,需要跳过这个，所以加个判断额外空间的大小即可。
    // 如果不是 '#' 就往里面加就是了，最后返回字符串。
    public boolean backspaceCompare(String S, String T) {
        return helper(S).equals(helper(T));
    }

    private String helper(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) == '#') {
                if (stringBuilder.length() > 0) {
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                }
            }
            else {
                stringBuilder.append(s.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        BackspaceStringCompare backspaceStringCompare = new BackspaceStringCompare();
        System.out.println(backspaceStringCompare.backspaceCompare("ab#c", "ad#c"));
    }
}
