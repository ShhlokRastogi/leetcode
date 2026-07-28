class Solution {
    public int[][] updateMatrix(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        Queue<int[]> q = new LinkedList<>();
        int[][] ans = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    q.offer(new int[]{i, j});
                    ans[i][j] = 0;
                } else {
                    ans[i][j] = -1;
                }
            }
        }

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!q.isEmpty()) {

            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for (int k = 0; k < 4; k++) {

                int newR = r + dr[k];
                int newC = c + dc[k];

                if (newR >= 0 && newR < n &&
                    newC >= 0 && newC < m &&
                    ans[newR][newC] == -1) {

                    ans[newR][newC] = ans[r][c] + 1;
                    q.offer(new int[]{newR, newC});
                }
            }
        }
        return ans;
    }
}
