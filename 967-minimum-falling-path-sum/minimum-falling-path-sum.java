class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];

        //base case
        for (int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j];
        }
        //start from i=1
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
               int ld = Integer.MAX_VALUE;
                int rd = Integer.MAX_VALUE;
                int u = matrix[i][j] + dp[i - 1][j];
                if (j - 1 >= 0)
                    ld = matrix[i][j] + dp[i - 1][j - 1];
                if (j + 1 < m)
                    rd = matrix[i][j] + dp[i - 1][j + 1];

                dp[i][j] = Math.min(u, Math.min(ld, rd));
            }
        }

        //now at the end row n-1 traverse find max
        int mini = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            mini = Math.min(mini, dp[n - 1][j]);
        }
        return mini;
    }
}