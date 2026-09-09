class Solution {
    public long countCommas(long n) {

        long ans = 0;

        // Numbers ≥ 1000 → each has at least 1 comma
        if(n >= 1000)
        {
            ans += (n - 999); 
        }

        // Numbers ≥ 1,000,000 → get 1 more comma
        if(n >= 1000000)
        {
            ans += (n - 999999); 
        }

        // Numbers ≥ 1,000,000,000 → get 1 more comma
        if(n >= 1000000000)
        {
            ans += (n - 999999999); 
        }

        // IMPORTANT: using 'L' because number is too big for int
        // int max ≈ 10^9, but here we go up to 10^15 → need long
        if(n >= 1000000000000L)
        {
            ans += (n - 999999999999L); 
        }

        // Same here → very large number, must use 'L' (long type)
        if(n >= 1000000000000000L)
        {
            ans += (n - 999999999999999L);
        }
        return ans;
    }
}