class Solution {
    boolean[][] visited;
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> q = new LinkedList<>();
        int m = rooms.length;
        int n = rooms[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) q.add(new int[] {i ,j});
            }
        }

        int[][] dirs = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
        while (!q.isEmpty()) {
            int[] cur = q.remove();
            int row = cur[0];
            int col = cur[1];

            for (int[] dir : dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow < 0 || newRow >= rooms.length || newCol < 0 || newCol >= rooms[0].length || rooms[newRow][newCol] != Integer.MAX_VALUE) continue;
                rooms[newRow][newCol] = rooms[row][col] + 1;
                q.add(new int[] {newRow, newCol});
            }
        }
    }
}
