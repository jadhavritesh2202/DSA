
class Solution {
    public int minFallingPathSum(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] dp = new int[n][m];

        // Base case
        for (int j = 0; j < m; j++) {
            dp[0][j] = mat[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {

                int ld = Integer.MAX_VALUE;
                int rd = Integer.MAX_VALUE;

                int u = mat[i][j] + dp[i - 1][j];

                if (j - 1 >= 0)
                    ld = mat[i][j] + dp[i - 1][j - 1];

                if (j + 1 < m)
                    rd = mat[i][j] + dp[i - 1][j + 1];

                dp[i][j] = Math.min(u, Math.min(ld, rd));
            }
        }

        int mini = Integer.MAX_VALUE;

        for (int j = 0; j < m; j++) {
            mini = Math.min(mini, dp[n - 1][j]);
        }

        return mini;
    }
}