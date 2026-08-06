class Solution {
    int countConnected(int V, ArrayList<ArrayList<Integer>> edges) {
        // code here
        //edges into adj list
         ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
         for(int i=0;i<V;i++){
             adj.add(new ArrayList<>());
         }
         
         //create connections
       for(int i=0;i<edges.size();i++){
           int u=edges.get(i).get(0);
           int v=edges.get(i).get(1);
           adj.get(u).add(v);
           adj.get(v).add(u);
       }
       
       int cnt=0;
       boolean[] visit=new boolean[V];
        for(int i=0;i<V;i++){
            if(!visit[i]){
                cnt++;
                dfs(i,visit,adj,V);
            }
        }
        return cnt;
        
    }
    public void dfs(int node,boolean[] visit, ArrayList<ArrayList<Integer>> adj,int V){
        visit[node]=true;
        for(int nei:adj.get(node)){
            if(!visit[nei]){
                dfs(nei,visit,adj,V);
            }
        }
    }
}