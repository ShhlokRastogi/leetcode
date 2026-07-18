class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        Queue<int[]> q = new LinkedList<>();

        int n = image.length;
        int m = image[0].length;

        boolean[][] visited = new boolean[n][m];

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        int reqcolor = image[sr][sc];

        if (reqcolor == color)
            return image;

        q.offer(new int[]{sr, sc});
        visited[sr][sc] = true;
        image[sr][sc] = color;

        while (!q.isEmpty()) {

            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];

            for (int i = 0; i < 4; i++) {

                int newRow = row + dr[i];
                int newCol = col + dc[i];

                if (newRow >= 0 && newCol >= 0 &&
                    newRow < n && newCol < m) {

                    if (image[newRow][newCol] == reqcolor &&
                        !visited[newRow][newCol]) {

                        image[newRow][newCol] = color;
                        visited[newRow][newCol] = true;
                        q.offer(new int[]{newRow, newCol});
                    }
                }
            }
        }

        return image;
    }
}
