class Pair{
    int node;
    int cost;
    Pair(int node,int cost){
        this.node=node;
        this.cost=cost;
    }
}
class Solution {
    public static int findCheapestCost(int n, int[][] edges, int src, int dst, int k) {
        // code here
          ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
         for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
         }

         for(int[] flight:edges){
            int u=flight[0];
            int v=flight[1];
            int cost=flight[2];
            adj.get(u).add(new Pair(v,cost));

         }
         int[] dist=new int[n];
         Arrays.fill(dist,Integer.MAX_VALUE);
         Queue<Pair> q=new LinkedList<>();
         int steps=0;
         q.add(new Pair(src,0));

         dist[src]=0;

         while(!q.isEmpty() && steps<=k){
            steps++;
            int size=q.size();
            while(size-->0){
                Pair p=q.remove();
                int node=p.node;
                int cost=p.cost;

                for(Pair nei:adj.get(node)){
                    int ele=nei.node;
                    int price=nei.cost;

                    if(cost+price < dist[ele]){
                        dist[ele]=cost+price;
                        q.add(new Pair(ele,cost+price));
                    }
                }
            }
         }

       return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];

    }
}