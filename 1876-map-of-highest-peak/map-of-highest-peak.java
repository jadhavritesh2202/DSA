class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    q.add(new int[] { i, j });
                    isWater[i][j] = 0;
                }else{
                    isWater[i][j]=-1;
                }
            }
        }
        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };
        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int[] node = q.remove();
                int val = isWater[node[0]][node[1]];
                for (int i = 0; i < 4; i++) {
                    int nr = node[0] + dr[i];
                    int nc = node[1] + dc[i];

                    if (nr >= 0 && nc >= 0 &&
                            nr < m && nc < n && isWater[nr][nc]==-1) {
                        isWater[nr][nc]=val+1;
                        q.add(new int[]{nr,nc});
                    }
                }
            }

        }
        return isWater;
    }
}