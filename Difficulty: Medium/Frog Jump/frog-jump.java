class Solution {
    int minCost(int[] height) {
        // code here
        
        int n=height.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return solve(n-1,height,dp);
        
    }
    public int solve(int idx,int[] height,int[] dp){
        //base case
        if(idx==0){
            return 0;
        }
        if(dp[idx]!=-1) return dp[idx];
        int left=solve(idx-1,height,dp)+Math.abs(height[idx]-height[idx-1]);
        int right=Integer.MAX_VALUE;
        if(idx>1){
            right=solve(idx-2,height,dp)+Math.abs(height[idx]-height[idx-2]);
        }
        return dp[idx]=Math.min(left,right);
        
    }
}