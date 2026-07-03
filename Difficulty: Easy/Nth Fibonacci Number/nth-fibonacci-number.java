class Solution {
    public int nthFibonacci(int n) {
        // code here
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
         return fun(n,dp);
    }
    public int fun(int n,int[] dp){
        if(n<=1) return n;
        if(dp[n]!=-1) return dp[n];
        
        return dp[n]=fun(n-1,dp)+fun(n-2,dp);
    }
}