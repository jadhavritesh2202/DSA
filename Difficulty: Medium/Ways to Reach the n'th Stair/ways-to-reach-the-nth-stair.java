class Solution {
    public int countWays(int n) {
        // code here
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return fun(0,n,dp);
        
    }
    private int fun(int idx,int n,int[] dp){
        if(idx==n){
            return 1;
        }
        if(idx>n){
            return 0;
        }
        if(dp[idx]!=-1) return dp[idx];
        int first=fun(idx+1,n,dp);
        int second=fun(idx+2,n,dp);
        return dp[idx]=first+second;
    }
}