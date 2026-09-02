class Solution {
     static final int m=2;
    public int numberOfWays(int n) {
        // code here
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n,dp);
        
    }
    public int solve(int n,int[] dp){
        if(n==0) return 1;
        
        int left=solve(n-1,dp);
        if(dp[n]!=-1) return dp[n];
        int right=0;
        if(n>=m){
            right=solve(n-2,dp);
        }
        return dp[n]=left+right;
    }
};