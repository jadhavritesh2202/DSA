class Solution {
    public int cherryPickup(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][][] dp = new int[rows][cols][cols];

        for (int i = 0; i < rows; i++) {
            for (int j1 = 0; j1 < cols; j1++) {
                Arrays.fill(dp[i][j1], -1);
            }
        }

        return helper(0,0,cols-1,cols,grid,dp);
        
    }
    int helper(int i,int j1,int j2,int cols,int[][] grid,int[][][] dp){
         if (j1 < 0 || j1 >= cols || j2 < 0 || j2 >= cols)
            return (int) -1e8;
        if(i==grid.length-1){
            if(j1==j2)
               return grid[i][j1];
            
            return grid[i][j1]+grid[i][j2];

        }

        if(dp[i][j1][j2]!=-1) return dp[i][j1][j2];

        int max=(int) -1e8;
         
         for(int d1=-1;d1<=1;d1++){
            for(int d2=-1;d2<=1;d2++){
                int value;
                  if (j1 == j2)
                    value = grid[i][j1];
                else
                    value = grid[i][j1] + grid[i][j2];
                
                value += helper(i + 1, j1 + d1, j2 + d2, cols, grid, dp);

                max = Math.max(max, value);
            }
         }
         return dp[i][j1][j2]=max;
    }
}