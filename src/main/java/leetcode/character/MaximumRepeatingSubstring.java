package leetcode.character;

public class MaximumRepeatingSubstring {

    public int maxRepeating(String sequence, String word) {

        int res = 0;
        StringBuilder words = new StringBuilder();
        words.append(word);
        while (sequence.length() >= words.toString().length()) {
            if (sequence.contains(words.toString())) {
                res ++;
            }
            words.append(word);
        }

        return res;
    }


    public static void main(String[] args) {
        String sequence = "ababc", word = "ab";
        MaximumRepeatingSubstring maximumRepeatingSubstring = new MaximumRepeatingSubstring();
        System.out.println(maximumRepeatingSubstring.maxRepeating(sequence, word));
    }

}
