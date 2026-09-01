class Solution {
    public int fillingBucket(int n) {
        // code here
        
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n,dp);
    }
    public int solve(int idx,int[] dp){
        if(idx==0) return 1;
        if(idx<0) return 0;
        if(dp[idx]!=-1) return dp[idx];
        
        return dp[idx]=solve(idx-1,dp)+solve(idx-2,dp);
        
    }
};