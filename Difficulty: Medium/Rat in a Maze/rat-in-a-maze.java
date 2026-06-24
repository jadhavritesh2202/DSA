class Solution {
       ArrayList<String> ans = new ArrayList<>();
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        int n=maze.length;
        if(maze[0][0]==0) return ans;
        
        boolean[][] vis = new boolean[n][n];
        solve(0,0,maze,vis,"",n);
        return ans;

        
    }
    public void solve(int i,int j,int[][] maze,boolean[][] vis,String path,int n){
        //base case
        if(i==n-1 && j==n-1){
            ans.add(path);
            return;
        }
        vis[i][j]=true;
        
        //down
        if(isSafe(i+1,j,maze,vis,n))
            solve(i+1,j,maze,vis,path+"D",n);

        // Left
        if(isSafe(i,j-1,maze,vis,n))
            solve(i,j-1,maze,vis,path+"L",n);

        // Right
        if(isSafe(i,j+1,maze,vis,n))
            solve(i,j+1,maze,vis,path+"R",n);

        // Up
        if(isSafe(i-1,j,maze,vis,n))
            solve(i-1,j,maze,vis,path+"U",n);
            
        //backtracting
        vis[i][j]=false;
    }
    boolean isSafe(int i,int j,int[][] maze,boolean[][] vis,int n){
        
        return i>=0 &&
               j>=0 &&
               i<n &&
               j<n &&
               maze[i][j]==1 && !vis[i][j];
    }
}