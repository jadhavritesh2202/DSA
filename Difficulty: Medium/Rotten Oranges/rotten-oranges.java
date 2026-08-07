class Solution {

    public int orangesRot(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        int freshOrange = 0;
        Queue<int[]> q = new LinkedList<>();

        // Put all rotten oranges into queue
        // and count fresh oranges
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (mat[i][j] == 2) {
                    q.add(new int[]{i, j});
                } 
                else if (mat[i][j] == 1) {
                    freshOrange++;
                }
            }
        }

        // No fresh oranges
        if (freshOrange == 0)
            return 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int time = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            // Process all oranges that are rotten
            // at the current minute
            while (size-- > 0) {

                int[] node = q.remove();

                int r = node[0];
                int c = node[1];

                // Check 4 directions
                for (int i = 0; i < 4; i++) {

                    int nr = r + dr[i];
                    int nc = c + dc[i];

                    if (nr >= 0 && nc >= 0 &&
                        nr < m && nc < n &&
                        mat[nr][nc] == 1) {

                        mat[nr][nc] = 2;
                        q.add(new int[]{nr, nc});

                        freshOrange--;
                    }
                }
            }

            time++;
        }

        return freshOrange == 0 ? time - 1 : -1;
    }
}