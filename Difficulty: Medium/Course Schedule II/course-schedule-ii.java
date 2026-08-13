class Solution {
    public ArrayList<Integer> findOrder(int n, int[][] pre) {
        // code here
          List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[n];
        for(int[] ele:pre){
            int u=ele[0];
            int v=ele[1];
            adj.get(v).add(u);
            indegree[u]++;
        }
        Queue<Integer> q=new LinkedList<>();
        //add ele which has 0 indegree
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
       ArrayList<Integer> ans=new ArrayList<>();
        while(!q.isEmpty()){
            int node=q.remove();
            ans.add(node);
            for(int nei:adj.get(node)){
                indegree[nei]--;
                if(indegree[nei]==0){
                    q.add(nei);
                }
            }
        }
        if(ans.size()!=n){
            return new ArrayList<>();
        }
        return ans;
    }
}