class Solution {
    public int orangesRotting(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j, 0});
                    visited[i][j] = true;
                }
            }
        }

        int ans = 0;

        while (!q.isEmpty()) {

            int[] node = q.poll();

            int row = node[0];
            int col = node[1];
            int time = node[2];

            ans = Math.max(ans, time);

            for (int i = 0; i < 4; i++) {

                int newRow = row + dr[i];
                int newCol = col + dc[i];

                if (newRow >= 0 && newRow < n &&
                    newCol >= 0 && newCol < m) {

                    if (grid[newRow][newCol] == 1 &&
                        !visited[newRow][newCol]) {

                        visited[newRow][newCol] = true;
                        grid[newRow][newCol] = 2;

                        q.offer(new int[]{newRow, newCol, time + 1});
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return ans;
    }
}
