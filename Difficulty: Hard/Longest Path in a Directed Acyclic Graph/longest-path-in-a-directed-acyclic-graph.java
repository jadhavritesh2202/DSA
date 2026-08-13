class Pair {
	int node;
	int wt;
	Pair(int node, int wt) {
		this.node = node;
		this.wt = wt;
	}
}
class Solution {
	public int[] maxDistance(int V, int src, ArrayList<ArrayList<Integer>> edges) {
		// code here
		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
		for (int i = 0; i<V; i++) {
			adj.add(new ArrayList<>());
		}
		for (List<Integer> edge : edges) {
			int u = edge.get(0);
			int v = edge.get(1);
			int w= edge.get(2);
			adj.get(u).add(new Pair(v,w));
		}
		
		int[] dist=new int[V];
		Arrays.fill(dist, Integer.MIN_VALUE);
		Queue<Pair> q=new LinkedList<>();
		dist[src]=0;
		q.add(new Pair(src,0));
		
		while(!q.isEmpty()){
		     Pair p=q.remove();
		     int node=p.node;
		     int wt=p.wt;
		     
		     for(Pair nei:adj.get(node)){
		         int ele=nei.node;
		         int wei=nei.wt;
		         
		         if( dist[ele] < wei+wt){
		             dist[ele]=wei+wt;
		             q.add(new Pair(ele,wei+wt));
		         }
		     }
		}
		return dist;
		
	}
}
