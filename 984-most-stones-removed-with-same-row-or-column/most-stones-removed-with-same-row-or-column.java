class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        boolean[] visited = new boolean[n];

        int groups = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            dfs(stones, i, visited);
            groups++;
        }

        return n - groups;
    }

    private void dfs(int[][] stones, int idx, boolean[] visited) {
        visited[idx] = true;

        int row = stones[idx][0];
        int col = stones[idx][1];

        for (int i = 0; i < stones.length; i++) {
            if (!visited[i] &&
                (stones[i][0] == row || stones[i][1] == col)) {

                dfs(stones, i, visited);
            }
        }
    }
}