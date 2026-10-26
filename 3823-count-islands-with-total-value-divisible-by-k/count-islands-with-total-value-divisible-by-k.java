class Solution {
    public int countIslands(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int cnt = 0;

        boolean[][] visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visit[i][j] && grid[i][j] > 0) {
                    long sum = dfs(i, j, visit, grid);

                    if (sum % k == 0) {
                        cnt++;
                    }
                }
            }
        }

        return cnt;
    }

    public long dfs(int i, int j, boolean[][] visit, int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        visit[i][j] = true;
        long sum = grid[i][j];

        int[] dr = {0, 0, 1, -1};
        int[] dc = {1, -1, 0, 0};

        for (int d = 0; d < 4; d++) {
            int nr = i + dr[d];
            int nc = j + dc[d];

            if (nr >= 0 && nc >= 0 && nr < n && nc < m
                    && !visit[nr][nc] && grid[nr][nc] > 0) {
                sum += dfs(nr, nc, visit, grid);
            }
        }

        return sum;
    }
}