class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m=grid.size();
        int n=grid.get(0).size();

        int[][] dist=new int[m][n];
        
    //fill infinity to all dist
        for(int i=0;i<m;i++){
             Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        Deque<int[]> dq=new ArrayDeque<>();
        dist[0][0]=grid.get(0).get(0);
        dq.addFirst(new int[]{0,0});

        int[] dr={-1,1,0,0};
        int[] dc={0,0,-1,1};

        //now we have run our daily 
        while(!dq.isEmpty()){
            int[] curr=dq.removeFirst();
            int r=curr[0];
            int c=curr[1];
            

            for(int k=0;k<4;k++){
                int nr=r+dr[k];
                int nc=c+dc[k];

                 if (nr < 0 || nr >= m || nc < 0 || nc >= n)
                    continue;
                
                int cost=grid.get(nr).get(nc);
                int newCost=dist[r][c]+cost;

                if(newCost<dist[nr][nc]){
                    dist[nr][nc]=newCost;

                    //add into deque
                    if(cost==0){
                        dq.addFirst(new int[]{nr,nc});
                    }else{
                        dq.addLast(new int[]{nr,nc});
                    }
                }


            }
        }
        return dist[m-1][n-1]<health;

    }
}