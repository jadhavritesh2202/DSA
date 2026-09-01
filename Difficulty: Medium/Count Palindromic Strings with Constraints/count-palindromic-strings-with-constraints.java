class Solution {
    static final long MOD = 1000000007L;

    public int palindromicStrings(int n, int k) {
        long ans = k;
        long ways = 1;

        for (int m = 1; m * 2 <= n; m++) {

            // Choose m distinct characters for the first half
            ways = ways * (k - m + 1) % MOD;

            // Even length palindrome: 2m
            ans = (ans + ways) % MOD;

            // Odd length palindrome: 2m + 1
            if (2 * m + 1 <= n) {
                long oddWays = ways * (k - m) % MOD;
                ans = (ans + oddWays) % MOD;
            }
        }

        return (int) ans;
    }
}