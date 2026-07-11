class Solution {
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        // code here
         ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        int n=edges.length;
        for(int i=0;i<V;i++)adj.add(new ArrayList<>());
        for(int i=0;i<n;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        boolean[] visit=new boolean[V+1];
        Arrays.fill(visit,false);
        
        for(int i=0;i<V;i++){
            if(!visit[i]){
                 ArrayList<Integer> list=new ArrayList<>();
                 dfs(i,visit,list,adj);
                 res.add(list);
            }
        }
        return res;
        
    }
    public void dfs(int node, boolean[] visit,ArrayList<Integer> list,  ArrayList<ArrayList<Integer>> adj){
        visit[node]=true;
        list.add(node);
        for(int nei:adj.get(node)){
            if(!visit[nei]){
                dfs(nei,visit,list,adj);
            }
        }
    }
}