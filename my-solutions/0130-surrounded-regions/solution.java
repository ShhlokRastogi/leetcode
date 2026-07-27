class Solution {
    void dfs(char[][] board, int[][] visited, int i, int j) {
        int n = board.length;
        int m = board[0].length;

        if (i < 0 || i >= n || j < 0 || j >= m)
            return;

        if (board[i][j] == 'X' || visited[i][j] == 1)
            return;

        visited[i][j] = 1;

        dfs(board, visited, i + 1, j);
        dfs(board, visited, i - 1, j);
        dfs(board, visited, i, j + 1);
        dfs(board, visited, i, j - 1);
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        Queue<int[]> q = new LinkedList<>();
        // Top row
        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O') {
                q.offer(new int[]{0, j});
            }
        }
        // Left column
        for (int i = 1; i < n; i++) {
            if (board[i][0] == 'O') {
                q.offer(new int[]{i, 0});
            }
        }
        // Bottom row
        for (int j = 1; j < m; j++) {
            if (board[n - 1][j] == 'O') {
                q.offer(new int[]{n - 1, j});
            }
        }
        // Right column
        for (int i = 1; i < n; i++) {
            if (board[i][m - 1] == 'O') {
                q.offer(new int[]{i, m - 1});
            }
        }
        int[][] visited = new int[n][m];
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            dfs(board, visited, curr[0], curr[1]);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' && visited[i][j] == 0) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
