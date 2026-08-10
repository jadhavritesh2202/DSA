class Triple {
        int effort;
        int row;
        int col;

        Triple(int effort, int row, int col) {
            this.effort = effort;
            this.row = row;
            this.col = col;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
           int m = heights.length;
        int n = heights[0].length;

        // dist[i][j] = minimum effort required to reach (i,j)
        int[][] dist = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

  PriorityQueue<Triple> pq =
            new PriorityQueue<>((a, b) -> a.effort - b.effort);
         dist[0][0]=0;
         pq.add(new Triple(0,0,0));
         int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        while(!pq.isEmpty()){
            Triple curr=pq.remove();
            int effort=curr.effort;
            int r=curr.row;
            int c=curr.col;

            //check dest
            if(r==m-1 && c==n-1) return effort;

            for(int k=0;k<4;k++){
                int nr = r + dr[k];
                int nc = c + dc[k];
              
               if (nr >= 0 && nr < m &&
                    nc >= 0 && nc < n) {
                    int diff=Math.abs(heights[r][c] - heights[nr][nc]);

                    int newEffort=Math.max(effort,diff);
                    if(newEffort < dist[nr][nc]){
                        dist[nr][nc]=newEffort;
                        pq.add(new Triple(newEffort,nr,nc));
                    }
                }
            }
        }
        return 0;
    }
}