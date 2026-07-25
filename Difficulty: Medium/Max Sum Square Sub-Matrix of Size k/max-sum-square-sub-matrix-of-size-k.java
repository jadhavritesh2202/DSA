
class Solution {

    public int maximumSum(int[][] matrix, int k) {

        int n = matrix.length;
        int m = matrix[0].length;

        int[][] prefix = new int[n + 1][m + 1];

        // Build prefix sum
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                prefix[i][j] =
                    matrix[i - 1][j - 1]
                    + prefix[i - 1][j]
                    + prefix[i][j - 1]
                    - prefix[i - 1][j - 1];
            }
        }

        int maxSum = Integer.MIN_VALUE;

        // Check every k x k square
        for (int i = 0; i <= n - k; i++) {
            for (int j = 0; j <= m - k; j++) {

                int sum =
                    prefix[i + k][j + k]
                    - prefix[i][j + k]
                    - prefix[i + k][j]
                    + prefix[i][j];

                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }
}