package leetcode.character;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }

        String res = strs[0];
        for (int i = 1; i < strs.length; i++){

            while (strs[i].indexOf(res) != 0){
                res = res.substring(0,res.length() - 1);
                if (res.isEmpty()) {
                    return "";
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        LongestCommonPrefix lpx = new LongestCommonPrefix();
        String[] strings = {"flower","flow","flight"};
        String  s= "adb";
        System.out.println(s.indexOf("a "));
        System.out.println(lpx.longestCommonPrefix(strings));
    }
}

/**
 * 遍历strs字符串数组，通过indexof()来逐步判断前缀相同的部分
 */