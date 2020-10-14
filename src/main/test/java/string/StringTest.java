package string;

public class StringTest {

    public static void main(String[] args) {
        char[] str = {'a','b'};
        char[] str1 = {'c','d'};
        exchange(str,str1);
        System.out.print(str[1] +"   "+ str1[1]);
        StringBuffer stringBuffer;
    }

    public static void exchange(char[] str1, char[] str2){
        str1[1] =  'd';
        str2[1] = 'f';
    }
}
