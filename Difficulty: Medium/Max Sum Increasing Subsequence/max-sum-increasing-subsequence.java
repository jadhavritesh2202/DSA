class Solution {
    int[] arr;
    int[][] dp;

    public int maxSumIS(int arr[]) {
        this.arr = arr;

        int n = arr.length;
        dp = new int[n][n + 1];

        for (int i = 0; i < n; i++) {
            java.util.Arrays.fill(dp[i], -1);
        }

        return solve(0, -1);
    }

    public int solve(int idx, int prev) {

        if (idx == arr.length) {
            return 0;
        }

        if (dp[idx][prev + 1] != -1) {
            return dp[idx][prev + 1];
        }

        // Don't take
        int notTake = solve(idx + 1, prev);

        // Take
        int take = Integer.MIN_VALUE;

        if (prev == -1 || arr[prev] < arr[idx]) {
            take = arr[idx] + solve(idx + 1, idx);
        }

        dp[idx][prev + 1] = Math.max(take, notTake);

        return dp[idx][prev + 1];
    }
}