class Solution {
    public int minCost(int n, int i, int d, int c) {
        // code here
        int dp[] = new int[n+1];
        dp[1] = i;
        for(int k=2;k<=n;k++){
            // We will have 3 options to find minimum costs to reach 'k'
            // 1: Cost to reach 'k-1' + i
            int min = dp[k-1] + i;
            if(k%2==0){
                // 2: If 'k' is even
                // Cost to reach 'k/2' + c (means double the length)
                min = Math.min(dp[k/2]+c, min);
            }else{
                // 2: If 'k' is odd (5)
                // Cost to reach 'k/2' + c + i = reach 2 -> double it -> 4 + insert = 5
                // Cost to reach 'k/2 + 1' + c + d = = reach 3 -> double it -> 6 + delete = 5
               min = Math.min(min, Math.min(dp[k/2]+c+i, dp[k/2 +1]+c+d)); 
            }
            dp[k] = min;
        }
        return dp[n];
    }
}
