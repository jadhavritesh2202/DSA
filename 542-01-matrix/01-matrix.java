class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        Queue<int[]> q=new LinkedList<>();

         for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.add(new int[]{i,j});
                }else{
                    mat[i][j]=-1;
                }
            }
         }
          int[] dr={0,1,0,-1};
          int[] dc={1,0,-1,0};
         while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                int[] val=q.poll();

                for(int k=0;k<4;k++){
                    int nr=val[0]+dr[k];
                    int nc=val[1]+dc[k];

                    if(nr<m && nc<n && nr>=0 && nc>=0 && mat[nr][nc]==-1){
                        mat[nr][nc]=mat[val[0]][val[1]]+1;
                        q.add(new int[]{nr,nc});
                    }
                }

            }
         }
         return mat;


    }
}