package leetcode.character;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
    private Map<Character, String> letter;
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null ||digits.length() == 0){
            return res;
        }
        initMap();
        helper(res, digits, 0, new StringBuilder());
        return res;

    }

    private void helper(List<String> res, String digits, int i, StringBuilder stringBuilder) {
        if (i == digits.length()){
            res.add(stringBuilder.toString());
        }
        else {
            String letters = letter.get(digits.charAt(i));
            int len = letters.length();
            for (int j = 0; j < len; j++) {
                stringBuilder.append(letters.charAt(j));
                helper(res, digits, i + 1, stringBuilder);
                stringBuilder.deleteCharAt(i);
            }
        }
    }

    private void initMap(){
        letter = new HashMap<>();
        letter.put('2', "abc");
        letter.put('3', "def");
        letter.put('4', "ghi");
        letter.put('5', "jkl");
        letter.put('6', "mno");
        letter.put('7', "pqrs");
        letter.put('8', "tuv");
        letter.put('9', "wxyz");
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber letterCombinationsOfAPhoneNumber = new LetterCombinationsOfAPhoneNumber();
        String digit = "23";
        System.out.println(letterCombinationsOfAPhoneNumber.letterCombinations(digit));
    }
}
