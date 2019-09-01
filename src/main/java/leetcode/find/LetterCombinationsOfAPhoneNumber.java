package leetcode.find;


import java.util.ArrayList;

/**
 * 题目
 * 给出一个仅包含数字的字符串，给出所有可能的字母组合。
 * 数字到字母的映射方式如下:(就像电话上数字和字母的映射一样)
 *
 * Input:Digit string "23"Output:["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 注意：虽然上述答案是按字典序排列的，但你的答案可以按任意的顺序给出
 */


public class LetterCombinationsOfAPhoneNumber {

    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0){
            res.add("");
            return res;
        }
        String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        helper(res, digits, 0,"",map);
        return res;
    }

    private void helper(ArrayList<String> res, String digits, int start, String s,String[] map) {
        if(start >= digits.length()){
            res.add(s);
            return;
        }

        String str = map[Character.getNumericValue(digits.charAt(start))];

        for(Character character : str.toCharArray()){
            helper(res, digits, start+ 1, s+character,map);
        }

    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber letterCombinationsOfAPhoneNumber = new LetterCombinationsOfAPhoneNumber();
        System.out.println(letterCombinationsOfAPhoneNumber.letterCombinations("23"));
    }
}


/**
 *解题思路
 *
 * 回溯法
 * 这里用个数组存储 字符串 ，依次读取数组内的字符，然后进行结合。这里需要注意StringBuilder 不能作为方法参数
 */