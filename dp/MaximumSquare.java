class Solution {
    public int maximalSquare(char[][] matrix) {
        // dp array stores the largest length of the square
        // that can be formed by the current grid
        
        int maxLen = 0, rows = matrix.length, cols = matrix[0].length;
        int[][] dp = new int[rows + 1][cols + 1];
        
        // top-down dp algorithm
        // given matrix:
        // 1 1
        // 1 1
        //
        // dp result:
        // 0 0 0
        // 0 1 1
        // 0 1 2
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                    maxLen = Math.max(dp[i][j], maxLen);
                }
            }
        }
        
        return maxLen * maxLen;
    }
}
