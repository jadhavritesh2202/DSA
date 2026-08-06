class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        boolean[][] visit = new boolean[m][n];
        int pixel=image[sr][sc];
        image[sr][sc] = color;
        dfs(sr, sc, image, color, visit,pixel);
        return image;
    }

    public void dfs(int i, int j, int[][] image, int color, boolean[][] visit,int pixel) {
        int m = image.length;
        int n = image[0].length;
        visit[i][j] = true;

        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, 1, 0, -1 };

        for (int k = 0; k < 4; k++) {
            int nr = i + dr[k];
            int nc = j + dc[k];
            if (nr >= 0 && nr < m &&
                    nc >= 0 && nc < n &&
                    !visit[nr][nc] && image[nr][nc]==pixel) {
                 image[nr][nc]=color;
                dfs(nr, nc,image,color, visit,pixel);
            }
        }
    }
}