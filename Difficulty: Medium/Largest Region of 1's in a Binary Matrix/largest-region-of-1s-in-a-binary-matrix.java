class Solution {
	int findMaxArea(int[][] grid) {
		// code here
		int m = grid.length;
		int n = grid[0].length;
		
		int maxArea = 0;
		boolean[][] visit = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!visit[i][j] && grid[i][j] == 1) {
					int area = dfs(i, j, visit, grid);
					maxArea = Math.max(maxArea, area);
				}
			}
		}
		return maxArea;
	}
	
	public int dfs(int i, int j, boolean[][] visit, int[][] grid) {
		
		int m = grid.length;
		int n = grid[0].length;
		visit[i][j] = true;
		
		int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
		int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
		int area = 1;
		for (int k = 0; k < 8; k++) {
			int nr = i + dr[k];
			int nc = j + dc[k];
			
			if (nr >= 0 && nr < m && nc >= 0 && nc < n &&
			!visit[nr][nc] && grid[nr][nc] == 1) {
				area += dfs(nr, nc, visit, grid);
			}
		}
		return area;
		
	}
};
