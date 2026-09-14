class Solution {
	class Triple {
		int row;
		int col;
		int dist;
		Triple(int row, int col, int dist) {
			this.row = row;
			this.col = col;
			this.dist = dist;
		}
	}
	int shortestPath(int[][] mat) {
		// code here
		int n = mat.length;
		int m = mat[0].length;
		// create unsafe boolean matrix
		boolean[][] unsafe = new boolean[n][m];
		
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		for (int i = 0; i<n; i++) {
			for (int j = 0; j<m; j++) {
				if (mat[i][j] == 0) {
					unsafe[i][j] = true;
					
					for (int d = 0; d<4; d++) {
						int nr = dr[d]+i;
						int nc = dc[d]+j;
						// checkmvalid
						if (nr >= 0 && nr<n && nc >= 0 && nc<m) {
							unsafe[nr][nc] = true;
						}
					}
				}
				
			}
		}
		
		Queue<Triple> q = new LinkedList<>();
		
		boolean[][] visit = new boolean[n][m];
		
		// multisorce bfs first col store in queue
		
		for (int i = 0; i<n; i++) {
			if (!unsafe[i][0]) {
				q.add(new Triple(i, 0, 1));
				visit[i][0] = true;
			}
		}
		
		while (!q.isEmpty()) {
			Triple curr = q.remove();
			int row = curr.row;
			int col = curr.col;
			int dist = curr.dist;
			
			if (col == m - 1)
				return dist;
			
			for (int d = 0; d<4; d++) {
				int nr = row + dr[d];
				int nc = col + dc[d];
				
				if (nr >= 0 && nr<n && nc >= 0 && nc<m && !unsafe[nr][nc] && !visit[nr][nc]) {
					q.add(new Triple(nr, nc, dist + 1));
					visit[nr][nc] = true;
				}
				
			}
		}
		
		return - 1;
		
	}
}
