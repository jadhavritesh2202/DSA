class Solution {
	
	public int countIslands(char[][] grid) {
		
		int m = grid.length;
		int n = grid[0].length;
		
		boolean[][] visited = new boolean[m][n];
		
		int cnt = 0;
		
		for (int i = 0; i < m; i++) {
			
			for (int j = 0; j < n; j++) {
				
				if (!visited[i][j] && grid[i][j] == 'L') {
					
					dfs(i, j, grid, visited);
					cnt++;
				}
			}
		}
		
		return cnt;
	}
	
	public void dfs(int i, int j, char[][] grid, boolean[][] visited) {
		int m = grid.length;
		int n = grid[0].length;
		
		visited[i][j] = true;
		
		// 8 direction
		int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
		int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
		
		for (int k = 0; k<8; k++) {
			int nr = i + dr[k];
			int nc = j + dc[k];
			
			if (nr >= 0 && nc >= 0 && nr<m && nc<n &&
			!visited[nr][nc] && grid[nr][nc] == 'L') {
				dfs(nr, nc, grid, visited);
			}
		}
		
	}
}
