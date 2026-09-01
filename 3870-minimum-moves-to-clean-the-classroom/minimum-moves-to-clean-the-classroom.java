class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length, n = classroom[0].length(), sr = -1, sc = -1, cnt = 0;
        int[][] id = new int[m][n];
        for (int[] row : id)
            Arrays.fill(row, -1);
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (classroom[i].charAt(j) == 'S') {
                    sr = i;
                    sc = j;
                }
                if (classroom[i].charAt(j) == 'L') {
                    id[i][j] = cnt++;
                }
            }
        int mask = 1 << cnt;
        int fullMask = mask - 1;
        int[][][] best = new int[m][n][mask];
        for (int[][] row : best)
            for (int[] col : row)
                Arrays.fill(col, -1);
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] { sr, sc, 0, energy, 0 });
        best[sr][sc][0] = energy;
        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            int newMask = cur[2], en = cur[3], dist = cur[4];
            if (newMask == fullMask)
                return dist;
            if (en == 0)
                continue;
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d], nc = c + dc[d];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n)
                    continue;
                if (classroom[nr].charAt(nc) == 'X')
                    continue;
                int newEn = en - 1;
                int t = newMask;
                if (classroom[nr].charAt(nc) == 'L') {
                    t |= (1 << id[nr][nc]);
                }
                if (classroom[nr].charAt(nc) == 'R')
                    newEn = energy;
                if (best[nr][nc][t] >= newEn)
                    continue;
                best[nr][nc][t] = newEn;
                q.offer(new int[] { nr, nc, t, newEn, dist + 1 });
            }
        }
        return -1;
    }
}