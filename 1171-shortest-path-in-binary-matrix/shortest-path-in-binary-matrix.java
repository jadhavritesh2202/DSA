class Pair {
    int first;
    int second;
    int dist;

    Pair(int first,int second,int dist){
        this.first=first;
        this.second=second;
        this.dist=dist;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
         if (grid[0][0] == 1 || grid[m-1][n-1] == 1)
            return -1;
        Queue<Pair> pq = new LinkedList<>();
        boolean[][] visit = new boolean[m][n];

        visit[0][0] = true;
        pq.add(new Pair(0, 0, 1));
        int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };
        while (!pq.isEmpty()) {
            int size = pq.size();
            while (size-- > 0) {
                Pair node=pq.remove();
                int r=node.first;
                int c=node.second;
                int dis=node.dist;
                if (r == n - 1 && c == n - 1)
                return dis;
                for (int k = 0; k < 8; k++) {
                    int nr = r + dr[k];
                    int nc = c + dc[k];
               
                     if (nr >= 0 && nr < n &&
                    nc >= 0 && nc < n &&
                    grid[nr][nc] == 0 &&
                    !visit[nr][nc]){
                    visit[nr][nc]=true;
                    pq.add(new Pair(nr,nc,dis+1));
                    }
                }
            }
        }
        return -1;

    }
}