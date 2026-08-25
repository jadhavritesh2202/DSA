class Solution {
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                 if(board[i][j]==word.charAt(0)){
                    if(dfs(i,j,0,board,word)) return true;
                 }
            }
        }
        return false;
    }
    public boolean dfs(int i,int j,int idx,char[][] board,String word){
        //base cases
        if(idx==word.length()) return true;

        if(i<0 || j<0 || i>=board.length || j>=board[0].length ||
              board[i][j]!=word.charAt(idx)){
                return false;
              }
        
        char temp=board[i][j];
        board[i][j]='$';
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        for(int k=0;k<4;k++){
            int nr=i+dr[k];
            int nc=j+dc[k];

            if(dfs(nr,nc,idx+1,board,word)){
               board[i][j]=temp;
               return true;
            }
            
        }
           board[i][j]=temp;
           return false;
    }
}