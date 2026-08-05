class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        //generate adj list
        int[] indegree = new int[n];
        for(int[] edge:invocations){
            int a=edge[0];
            int b=edge[1];
            adj.get(a).add(b);
            indegree[edge[1]]++;
        }

        boolean[] suspicious = new boolean[n];

        Queue<Integer> q = new LinkedList<>();
        q.add(k);
        suspicious[k] = true;

        while(!q.isEmpty()){
           int node=q.remove();
           for(int nei:adj.get(node)){
              indegree[nei]--;
            if(!suspicious[nei]){
                 suspicious[nei] = true;
                    q.add(nei);
            }
           }
        }

        boolean canRemove=true;
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(suspicious[i] && indegree[i]>0){
                canRemove=false;
                break;
            }else if(!suspicious[i]){
                ans.add(i);
            }
        }

        if(!canRemove){
            List<Integer> allNode=new ArrayList<>(n);
             for (int i = 0; i < n; i++) {
                allNode.add(i);
            }
            return allNode;
        }
        return ans;
       
    }
}