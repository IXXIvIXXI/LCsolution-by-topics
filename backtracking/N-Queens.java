class Solution {
    // for negative diagonals, r - c
    // for positive diagonals, r + c
    // strategy:
    //   backtracking, placing one queen on each row and
    //   each time check if there is a queen in the same col
    //   postive or negative diagonal
    char[][] board;
    Set<Integer> colSet;
    Set<Integer> negDiagonal;
    Set<Integer> posDiagonal;
    public List<List<String>> solveNQueens(int n) {
        colSet = new HashSet<>();
        negDiagonal = new HashSet<>();
        posDiagonal = new HashSet<>();
        board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        List<List<String>> res = new ArrayList<>();
        backtracking(0, n, res);
        return res;
    }
    
    private void backtracking(int row, int n, List<List<String>> res) {
        if (row == n) {
            List<String> solution = toList(board);
            res.add(solution);
        }
        
        for (int col = 0; col < n; col++) {
            if (colSet.contains(col) ||
                negDiagonal.contains(row - col) ||
                posDiagonal.contains(row + col)) {
                continue;
            }
            
            board[row][col] = 'Q';
            colSet.add(col);
            negDiagonal.add(row - col);
            posDiagonal.add(row + col);
            
            backtracking(row + 1, n, res);
            
            board[row][col] = '.';
            colSet.remove(col);
            negDiagonal.remove(row - col);
            posDiagonal.remove(row + col);
        }
    }
    
    private List<String> toList(char[][] board) {
        List<String> res = new ArrayList<>();
        
        for (int row = 0; row < board.length; row++) {
            String curRow = new String(board[row]);
            res.add(curRow);
        }
        return res;
    }
}
