class Solution {
    int cnt;

    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        cnt = 0;

        int[][] dp = new int[n][target + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(0, nums, target, dp);
    }

    public int solve(int idx, int[] arr, int k, int[][] dp) {

        // base case
        if (k == 0) {
            return 1;
        }

        if (k < 0)
            return 0;

        if (idx >= arr.length)
            return 0;

        if (dp[idx][k] != -1)
            return dp[idx][k];

        int take = solve(0, arr, k - arr[idx], dp);

        int notTake = solve(idx + 1, arr, k, dp);

        return dp[idx][k] = take + notTake;
    }
}