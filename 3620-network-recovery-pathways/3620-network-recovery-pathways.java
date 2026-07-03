import java.util.*;

class Solution {

    private boolean check(long minEdge, int[] head, int[] next, int[] to,
                          int[] weight, List<Integer> topo,
                          boolean[] online, long k, int n, long[] dist) {

        long INF = Long.MAX_VALUE / 4;
        Arrays.fill(dist, INF);
        dist[0] = 0;

        for (int u : topo) {

            if (dist[u] == INF || dist[u] > k)
                continue;

            for (int e = head[u]; e != -1; e = next[e]) {

                int v = to[e];
                int w = weight[e];

                // Edge cost must be at least minEdge
                if (w < minEdge)
                    continue;

                // Intermediate nodes must be online
                if (v != n - 1 && !online[v])
                    continue;

                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        return dist[n - 1] <= k;
    }

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {

        int n = online.length;
        int m = edges.length;

        // Forward Star graph
        int[] head = new int[n];
        Arrays.fill(head, -1);

        int[] next = new int[m];
        int[] to = new int[m];
        int[] weight = new int[m];
        int[] indegree = new int[n];

        int maxEdge = 0;

        for (int i = 0; i < m; i++) {

            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            to[i] = v;
            weight[i] = w;

            next[i] = head[u];
            head[u] = i;

            indegree[v]++;

            maxEdge = Math.max(maxEdge, w);
        }

        // Topological Sort (Kahn's Algorithm)
        int[] queue = new int[n];
        int front = 0, rear = 0;

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue[rear++] = i;
            }
        }

        List<Integer> topo = new ArrayList<>();

        while (front < rear) {

            int u = queue[front++];
            topo.add(u);

            for (int e = head[u]; e != -1; e = next[e]) {

                int v = to[e];

                indegree[v]--;

                if (indegree[v] == 0) {
                    queue[rear++] = v;
                }
            }
        }

        long[] dist = new long[n];

        long low = 0;
        long high = maxEdge;

        int ans = -1;

        while (low <= high) {

            long mid = low + (high - low) / 2;

            if (check(mid, head, next, to, weight, topo, online, k, n, dist)) {
                ans = (int) mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}