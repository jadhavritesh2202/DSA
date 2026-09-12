class Solution {
    public int maxSum(List<Integer> arr) {
        int n = arr.size();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return solve(n - 1, arr, dp);
    }

    int solve(int idx, List<Integer> arr, int[] dp) {

        if (idx < 0) {
            return 0;
        }

        if (dp[idx] != -1) {
            return dp[idx];
        }

        // Take current
        int take = arr.get(idx) + solve(idx - 1, arr, dp);

        // Skip current, previous must be taken
        int skip = 0;

        if (idx > 0) {
            skip = arr.get(idx - 1) + solve(idx - 2, arr, dp);
        }

        return dp[idx] = Math.max(take, skip);
    }
}