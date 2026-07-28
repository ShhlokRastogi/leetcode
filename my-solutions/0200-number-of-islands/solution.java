class Solution {
    Queue<int[]> q = new LinkedList<>();
    int n, m;
    boolean[][] visited;
    void bfs(char[][] grid) {

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        while (!q.isEmpty()) {

            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for (int i = 0; i < 4; i++) {

                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < n &&
                    nc >= 0 && nc < m &&
                    !visited[nr][nc] &&
                    grid[nr][nc] == '1') {

                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }

    public int numIslands(char[][] grid) {

        n = grid.length;
        m = grid[0].length;
        visited = new boolean[n][m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    visited[i][j] = true;
                    q.offer(new int[]{i, j});
                    bfs(grid);
                }
            }
        }
        return count;
    }
}
