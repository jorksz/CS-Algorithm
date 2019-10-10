package leetcode.character;

/**
 * 字符串"PAYPALISHIRING"写成3行的Z字形的样式如下：
 * P   A   H   N↵A P L S I I G↵Y   I   R
 * 按行读这个Z字形图案应该是 "PAHNAPLSIIGYIR"
 * 请编写代码完成将字符串转化为指定行数的Z字形字符串：
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3)应该返回"PAHNAPLSIIGYIR"
 */


public class ZigzagConversion {

    public static String convert(String s, int nRows) {

        if(s == null || s.length() == 0){
            return s;
        }

        if(nRows == 1){
            return s;
        }

        int size = 2*nRows - 2;
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < nRows; i++){
            for(int j = i; j < s.length(); j += size){

                stringBuilder.append(s.charAt(j));
                //注添加中间的那部分
                if(i != 0 && i != nRows - 1 && j + size - 2*i < s.length()){
                    stringBuilder.append(s.charAt(j + size - 2*i));
                }
            }
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING",3));
    }
}

/**
 *解题思路
 *
 * 参考博客
 * https://blog.csdn.net/linhuanmars/article/details/21145039
 *
 *
 * 找规律，每个小Z的周期为 2* n - 2(n为行),接下来就是对于每一行先把往下走的那一列的字符加进去，
 * 然后有往上走的字符再加进去即可。时间复杂度是O(n),空间复杂度是O(1)
 *
 * 关于中间那Z的字符如何获取其坐标，其实j-i就是zigzag的起始字符，然后我们是要倒数第i个，
 * 因为一个zigzag有size个字符，所以倒数第i个就是size-i，我们要赋值的字符就是(j-i)+(size-i)=j+size-2*i了
 *
 *
 * 关于如何得出这个规律我是从这篇博客知道的
 * https://blog.csdn.net/zgwangbo/article/details/84331204
 *
 *
 */