// LC 130
class Solution {
    // dfs
    // any O on the boundary cannot be converted to X to we
    // start from each boundary and apply dfs
    int[][] DIRECTIONS = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
    public void solve(char[][] board) {
        int col = board.length;
        int row = board[0].length;
        
        for (int i = 0; i < col; i++) {
            if (board[i][0] == 'O') dfs(board, i, 0);
            
            if (board[i][row - 1] == 'O') dfs(board, i, row - 1);
        }
        
        for (int i = 0; i < row; i++) {
            if (board[0][i] == 'O') dfs(board, 0, i);
            
            if(board[col - 1][i] == 'O') dfs(board, col - 1, i);
        }
        
        for (int i = 0; i < col; i++) {
            for(int j = 0; j < row; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == 'A') board[i][j] = 'O';
            }
        }
    }
    
    private void dfs(char[][] board, int col, int row) {
        if (board[col][row] == 'X') return;
        board[col][row] = 'A';
        for (int[] dir : DIRECTIONS) {
            int newCol = col + dir[0];
            int newRow = row + dir[1];
            
            if (newCol < 0 || newCol >= board.length || newRow < 0 || newRow >= board[0].length) continue;
            // check if it's visited
            if (board[newCol][newRow] != 'A') dfs(board, newCol, newRow);
        }
    }
}
