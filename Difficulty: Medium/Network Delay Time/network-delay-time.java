class Pair {
    int node;
    int dist;

    Pair(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }
}

class Solution {
    public int findDelayTime(int V, int[][] edges, int src) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Build graph
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj.get(u).add(new Pair(v, wt));
        }

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a, b) -> a.dist - b.dist);

        dist[src] = 0;
        pq.offer(new Pair(src, 0));

        while (!pq.isEmpty()) {

            Pair p = pq.poll();

            int node = p.node;
            int currDist = p.dist;

            // stale entry
            if (currDist > dist[node])
                continue;

            for (Pair nei : adj.get(node)) {

                int adjNode = nei.node;
                int wt = nei.dist;

                int newDist = currDist + wt;

                if (newDist < dist[adjNode]) {

                    dist[adjNode] = newDist;

                    pq.offer(new Pair(adjNode, newDist));
                }
            }
        }

        int maxTime = 0;

        for (int d : dist) {

            if (d == Integer.MAX_VALUE)
                return -1;

            maxTime = Math.max(maxTime, d);
        }

        return maxTime;
    }
}