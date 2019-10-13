package offer.string;

/**
 * 题目  - 替换空格
 *
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class ReplaceBlank {

    public static String replaceSpace(StringBuffer str) {
        if(str.length() == 0 || str == null){
            return str.toString();
        }

        StringBuilder stringBuilder = new StringBuilder();
        String temp = str.toString();
        for(int i = 0; i < temp.length();i++){
            if(temp.charAt(i) == ' '){
                stringBuilder.append("%20");
            }
            else {
                stringBuilder.append(temp.charAt(i));
            }
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("We Are Happy");
        System.out.println(replaceSpace(stringBuffer));
    }

}

/**
 * 感觉不同的语言有不同的解法，我用的是Java,Java有个replace()的API，如果不使用API，普遍解法是遍历找到空格然后替换
 *
 * 而书上的最优解法，是预留两个指针，从后往前替换，先统计空格的数量，然后计算替换之后的字符串总长度，核心是减少字符移动的次数。
 * 但是对Java来说字符串的移动我们不需要管，所以我感觉这题用Java无法达到书上O（n)的效果。
 */