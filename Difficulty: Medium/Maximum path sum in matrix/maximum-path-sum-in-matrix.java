class Solution {
    public int maximumPath(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] dp = new int[n][m];

        // Base case
        for (int j = 0; j < m; j++) {
            dp[0][j] = mat[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {

                int ld = Integer.MIN_VALUE;
                int rd = Integer.MIN_VALUE;

                int u = mat[i][j] + dp[i - 1][j];

                if (j - 1 >= 0)
                    ld = mat[i][j] + dp[i - 1][j - 1];

                if (j + 1 < m)
                    rd = mat[i][j] + dp[i - 1][j + 1];

                dp[i][j] = Math.max(u, Math.max(ld, rd));
            }
        }

        int maxi = Integer.MIN_VALUE;

        for (int j = 0; j < m; j++) {
            maxi = Math.max(maxi, dp[n - 1][j]);
        }

        return maxi;
    }
}