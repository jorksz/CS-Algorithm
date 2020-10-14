package offer.string;

public class StringValueNum {
    public boolean isNumber(String s) {
        if (s.endsWith("f") || s.endsWith("D")){
            return false;
        }
        try {
            Double.valueOf(s);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public static void main(String[] args) {
        StringValueNum stringValueNum = new StringValueNum();
        System.out.println(stringValueNum.isNumber("959440.94f"));
    }
}
