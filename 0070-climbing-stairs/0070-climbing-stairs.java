class Solution {
    public int climbStairs(int n) {
        // if(n==0) return 1;
        // if(n==1) return 1;
        // int left=climbStairs(n-1);
        // int right=climbStairs(n-2);
        // return left+right;
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return steps(n,dp);
    
    }
    public int steps(int n,int[] dp){
             if(n<=1) return 1;
             if(dp[n]!=-1) return dp[n];
             return dp[n]=steps(n-1,dp)+steps(n-2,dp);
    }
}