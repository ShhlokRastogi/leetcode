class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;      
        int m = grid[0].length;
        boolean[][] visited= new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        // Top row
        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 1) {
                visited[0][j] = true;
                q.offer(new int[]{0, j});
            }
        }
        // Left column
        for (int i = 1; i < n; i++) {
            if (grid[i][0] == 1) {
                visited[i][0] = true;
                q.offer(new int[]{i, 0});
            }
        }
        // Bottom row
        for (int j = 1; j < m; j++) {
            if (grid[n - 1][j] == 1) {
                visited[n-1][j] = true;
                q.offer(new int[]{n - 1, j});
            }
        }
        // Right column
        for (int i = 1; i < n; i++) {
            if (grid[i][m - 1] == 1) {
                visited[i][m-1] = true;
                q.offer(new int[]{i, m - 1});
            }
        }
        int[] dc={0,0,1,-1};
        int[] dr={1,-1,0,0};
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < n &&
                    nc >= 0 && nc < m &&
                    !visited[nr][nc] && grid[nr][nc]==1) {

                        visited[nr][nc] = true;
                        q.offer(new int[]{nr, nc});
                }
            }
        }
        int count=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visited[i][j] && grid[i][j]==1){
                    count++;
                }
            }
        }
        return count;
    }
}
