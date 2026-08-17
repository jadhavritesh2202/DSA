class Solution {
    static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return Math.min(solve(0, n, cost, dp),
                        solve(1, n, cost, dp));
    }

    private static int solve(int idx, int n, int[] cost, int[] dp) {
        if (idx >= n) {
            return 0;
        }

        if (dp[idx] != -1) {
            return dp[idx];
        }

        int oneStep = cost[idx] + solve(idx + 1, n, cost, dp);
        int twoStep = cost[idx] + solve(idx + 2, n, cost, dp);

        return dp[idx] = Math.min(oneStep, twoStep);
    }
}