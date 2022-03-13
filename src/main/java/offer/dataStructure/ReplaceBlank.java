package offer.dataStructure;

/**
 * 剑指 Offer 05. 替换空格
 */
public class ReplaceBlank {
    public String replaceSpace(String s) {
        // API
        //s.replace(" ", "%20");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isSpaceChar(c)) {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String str = "a b c";
        ReplaceBlank replaceBlank = new ReplaceBlank();
        System.out.println(replaceBlank.replaceSpace(str));
    }
}
