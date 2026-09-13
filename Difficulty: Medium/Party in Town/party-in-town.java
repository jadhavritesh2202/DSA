class Solution {
    public int partyHouse(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int n=adj.size();
        
        if(n==1) return 0;
        
        //step1-> find one end of diameter  node at 0 and idx at 1
        int[] first=bfs(adj,1);
        int farthestNode=first[0];
        
        //find diameter of lenth
        int[] second=bfs(adj,farthestNode);
        int diameter=second[1];
        
        return (diameter+1)/2;
         
        
    }
    private int[] bfs(ArrayList<ArrayList<Integer>> adj,int start){
        int n=adj.size();
        
        int[] dist=new int[n+1];
        Arrays.fill(dist,-1);
        
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        dist[start]=0;
        
        int farthestNode=start;
        int farthestDist=0;
        while(!q.isEmpty()){
            int node=q.remove();
            for(int next:adj.get(node-1)){
                if(dist[next]==-1){
                    dist[next]=1+dist[node];
                    q.add(next);
                    
                    if(dist[next]>farthestDist){
                        farthestDist=dist[next];
                        farthestNode=next;
                    }
                }
            }
        }
        return new int[]{farthestNode,farthestDist};
        
        
        
        
        
        
        
        
        
        
        
        
    }
}