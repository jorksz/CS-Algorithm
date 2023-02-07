package niukeTop101.str;

public class BM83 {

    public String trans(String s, int n) {
        // write code here
        if (s.isEmpty()) {
            return s;
        }
        String[] strings = s.split(" ");
        if (strings.length == 0) {
            return s;
        }
        boolean isEndWithBlank = s.endsWith(" ");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(isEndWithBlank ? " " : "");
        for (int i = strings.length - 1; i >= 0; i--) {
            String str = strings[i];
            if (!str.equals("")) {
                for (int j = 0; j < str.length(); j++) {
                    if (Character.isLowerCase(str.charAt(j))) {
                        stringBuilder.append(Character.toUpperCase(str.charAt(j)));
                    } else {
                        stringBuilder.append(Character.toLowerCase(str.charAt(j)));
                    }
                }
            }
            if (i != 0) {
                stringBuilder.append(" ");
            }
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        BM83 bm83 = new BM83();
        String str = "               ";
        System.out.println(bm83.trans(str, 4));
    }
}
