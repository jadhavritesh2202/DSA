class Solution {
    boolean[][] visit;
    public int closedIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int cnt=0;
        visit=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0 && !visit[i][j]){
                    boolean isBoundry=dfs(i,j,grid);

                    if(!isBoundry){
                        cnt++;
                    }  
                }
            }
        }
        return cnt;
        
    }
    public boolean dfs(int i,int j,int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
         visit[i][j]=true;
         boolean isBoundary=i==0 || j==0 || i==m-1 ||j==n-1;
           int[] dr = {-1, 0, 1, 0};
         int[] dc = {0, 1, 0, -1};

        for(int k=0;k<4;k++){
            int nr=i+dr[k];
            int nc=j+dc[k];

             if (nr >= 0 && nr < grid.length &&
                nc >= 0 && nc < grid[0].length &&
                grid[nr][nc] == 0 && !visit[nr][nc]) {

                if (dfs(nr, nc, grid)) {
                    isBoundary = true;
                }
            }
        }
        return isBoundary;
         
    }
}