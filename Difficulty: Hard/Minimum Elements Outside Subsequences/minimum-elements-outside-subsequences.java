class Solution {
    int[][][] dp;
    public int minCount(int[] arr) {
        int n = arr.length;
     
        dp=new int[n][101][101];
        for(int[][] d:dp){
            for(int[] d1:d){
                Arrays.fill(d1,-1);
            }
        }
        int maxUsed = solve(0, 0, 0, arr);

        return n - maxUsed;
    }

    public int solve(int idx, int incr, int decr, int[] arr) {

        if (idx == arr.length) {
            return 0;
        }
         if(dp[idx][incr][decr]!=-1) return dp[idx][incr][decr];
        // Skip current element
        int ans = solve(idx + 1, incr, decr, arr);

        // Put in increasing subsequence
        if (incr == 0 || arr[idx] > incr) {
            int inc = 1 + solve(idx + 1, arr[idx], decr, arr);
            ans = Math.max(ans, inc);
        }

        // Put in decreasing subsequence
        if (decr == 0 || arr[idx] < decr) {
            int dec = 1 + solve(idx + 1, incr, arr[idx], arr);
            ans = Math.max(ans, dec);
        }

        return dp[idx][incr][decr]=ans;
    }
}