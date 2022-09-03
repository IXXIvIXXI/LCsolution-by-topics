class Solution {
    // strategy:
    // having (m + 1) x (n + 1) dp 2d array
    // initialize n + 1 row and m + 1 col as max val
    // except the one below grid[m - 1][n - 1] as 0
    // to update value: grid[curRow][curCol] + min(belowVal of dp, rightVal of dp)
    // two edge cases current spot is on the last col or last row
    // don't process if it's the last bucket grid[m-1][n-1]
    public int minPathSum(int[][] grid) {
        for (int row = grid.length - 1; row >= 0; row--) {
            for(int col = grid[0].length - 1; col >= 0; col--) {
                if (row == grid.length - 1 && col != grid[0].length - 1) {
                    grid[row][col] += grid[row][col + 1];
                } else if (row != grid.length - 1 && col == grid[0].length - 1) {
                    grid[row][col] += grid[row + 1][col];
                } else if (row != grid.length - 1 && col != grid[0].length - 1) {
                    grid[row][col] = grid[row][col] + Math.min(grid[row + 1][col], grid[row][col + 1]);    
                }
            }
        }
        
        return grid[0][0];
    }
}
