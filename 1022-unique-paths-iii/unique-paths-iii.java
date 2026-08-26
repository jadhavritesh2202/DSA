class Solution {
    int ans;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int cnt = 1;
        int sr = 0, sc = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    cnt++;
                }

                if (grid[i][j] == 1) {
                    sr = i;
                    sc = j;
                }
            }
        }

        findPath(sr, sc, 1, grid, cnt, m, n);

        return ans;
    }

    void findPath(int i, int j, int count,
                  int[][] grid, int cnt, int m, int n) {

        if (i < 0 || i >= m || j < 0 || j >= n ||
            grid[i][j] == -1) {
            return;
        }

        if (grid[i][j] == 2) {
            if (count == cnt+1) {
                ans++;
            }
            return;
        }

        int temp = grid[i][j];
        grid[i][j] = -1;

        for (int k = 0; k < 4; k++) {
            int nr = i + dr[k];
            int nc = j + dc[k];
            
            findPath(nr, nc, count + 1,
                     grid, cnt, m, n);
        }

        grid[i][j] = temp;
    }
}