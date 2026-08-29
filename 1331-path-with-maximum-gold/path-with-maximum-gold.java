class Solution {
    int max = 0;

    public int getMaximumGold(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != 0) {
                    dfs(i, j, 0, grid);
                }
            }
        }
        return max;

    }

    public void dfs(int i, int j, int sum, int[][] grid) {

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length ||
                grid[i][j] == -1 || grid[i][j] == 0) {
            max = Math.max(max, sum);
            return;
        }
        sum += grid[i][j];
        int temp = grid[i][j];
        grid[i][j] = -1;
        int[] dx = { 1, -1, 0, 0 };
        int[] dy = { 0, 0, 1, -1 };

        for (int d = 0; d < 4; d++) {
            dfs(i + dx[d], j + dy[d], sum, grid);
        }

        grid[i][j] = temp;

    }
}