class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int l = e[0];
            int r = e[1];

            adj.get(l).add(r);
            adj.get(r).add(l);
        }

        boolean[] visit = new boolean[n];
        int comp = 0;

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                int[] count = new int[2];

                dfs(i, adj, visit, count);

                int vertices = count[0];
                int edgesCount = count[1];

                if (edgesCount == vertices * (vertices - 1)) {
                    comp++;
                }
            }
        }

        return comp;
    }

    public void dfs(int node,
                    ArrayList<ArrayList<Integer>> adj,
                    boolean[] visit,
                    int[] count) {

        visit[node] = true;

        count[0]++;                     // vertices
        count[1] += adj.get(node).size(); // degree sum

        for (int ele : adj.get(node)) {
            if (!visit[ele]) {
                dfs(ele, adj, visit, count);
            }
        }
    }
}