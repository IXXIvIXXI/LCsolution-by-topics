class Solution {
    // word1: abc
    //        i

    // word2: adc
    //        j

    // delete: i + 1, j
    // insert: i, j + 1
    // replace: i + 1, j + 1
    
    // dp idea:
    // bottom up dp
    // dp size [word1.length + 1][word2.length + 1]
    //  a d c
    // a      3 word2 currently is empty so we need 3 insertions
    // b      2
    // c      1
    //  3 2 1 0
    //  at (0, 3) word 1 is empty so word2 needs 3 deletions
    
    // if two current characters are same, dp[i][j] = dp[i+1][j+1]
    // if different then dp[i][j] = 1 + min(insert, replace, delete)
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        
        for (int i = 0; i< dp.length; i++) {
            dp[i][word2.length()] = word1.length() - i;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[word1.length()][i] = word2.length() - i;
        }
        
        for (int i = word1.length() - 1; i >= 0; i--) {
            for (int j = word2.length() - 1; j >= 0; j--) {
                if (word1.charAt(i) == word2.charAt(j)) dp[i][j] = dp[i + 1][j + 1];
                else {
                    dp[i][j] = 1 + Math.min(dp[i + 1][j + 1],
                                            Math.min(dp[i + 1][j], dp[i][j + 1]));
                }
            }
        }
        
        return dp[0][0];
    }
}
