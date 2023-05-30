package niukeTop101.dp;

public class BM66 {

    public String LCS (String str1, String str2) {
        // write code here
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        int maxLenIndex = 0;
        int maxLen = 0;
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j] + 1;
                    if (dp[i+1][j+1] > maxLen) {
                        maxLen = dp[i+1][j+1];
                        maxLenIndex = i;
                    }
                } else {
                    dp[i+1][j+1] = 0;
                }
            }
        }

        return str1.substring(maxLenIndex - maxLen + 1, maxLenIndex + 1);
    }

    public static void main(String[] args) {
        BM66 bm66 = new BM66();
        String str1 = "22222";
        String str2 = "22222";
        System.out.println(bm66.LCS(str1, str2));
    }
}
