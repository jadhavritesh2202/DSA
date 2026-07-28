class Pair {
    int node;
    int cost;

    Pair(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
}

class Solution {
    public int shortestPath(int V, int src, int dest, int[][] edges) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Build undirected graph
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }

        // Min Heap based on cost
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.cost, b.cost)
        );

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;
        pq.offer(new Pair(src, 0));

        while (!pq.isEmpty()) {

            Pair p = pq.poll();

            int node = p.node;
            int cost = p.cost;

            // Ignore outdated entry
            if (cost > dist[node]) {
                continue;
            }

            // Explore neighbours
            for (Pair nei : adj.get(node)) {

                int nextNode = nei.node;
                int edgeWeight = nei.cost;

                int totalCost = cost + edgeWeight;

                if (totalCost < dist[nextNode]) {

                    dist[nextNode] = totalCost;

                    pq.offer(new Pair(nextNode, totalCost));
                }
            }
        }

        if (dist[dest] == Integer.MAX_VALUE) {
            return -1;
        }

        return dist[dest];
    }
}