class Solution {
    int dp[]=new int[1001];
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        Arrays.fill(dp,-1);
        return Math.min(solve(0,n,cost),solve(1,n,cost));
    }
    private int solve(int idx,int n,int[] cost){
        if(idx>=n){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int a=cost[idx]+solve(idx+1,n,cost);
        int b=cost[idx]+solve(idx+2,n,cost);
       return dp[idx]=Math.min(a,b);
    }
    

}