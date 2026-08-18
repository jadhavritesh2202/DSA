class Solution {
    public int findMaxSum(int arr[]) {

        int n = arr.length;
        int[] dp = new int[n];

        dp[0] = arr[0];

        for (int i = 1; i < n; i++) {

            // Take current element
            int take = arr[i];
            if (i > 1) {
                take += dp[i - 2];
            }

            // Don't take current element
            int notTake = dp[i - 1];

            dp[i] = Math.max(take, notTake);
        }

        return dp[n - 1];
    }
}