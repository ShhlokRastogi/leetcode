class Solution {
    char[][] board;
    String word;
    boolean[][] visited;
    public boolean dfs(int i, int j, int wordIndex) {

        if (wordIndex == word.length() - 1) {
            return true;
        }

        visited[i][j] = true;
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        for (int k = 0; k < 4; k++) {

            int nr = i + dr[k];
            int nc = j + dc[k];

            if (nr >= 0 && nr < board.length &&
                nc >= 0 && nc < board[0].length &&
                !visited[nr][nc] &&
                board[nr][nc] == word.charAt(wordIndex + 1)) {

                if (dfs(nr, nc, wordIndex + 1)) {
                    return true;
                }
            }
        }

        visited[i][j] = false;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
