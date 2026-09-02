class Solution {
    public int minimizeCost(int k, int arr[]) {
        // code here
        int n=arr.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return solve(n-1,k,arr,dp);
    }
    public int solve(int i,int k,int[] arr,int[] dp){
        if(i==0) return 0;
        int minCost=Integer.MAX_VALUE;
        if(dp[i]!=-1) return dp[i];
        for(int j=i-1;j>=Math.max(0,i-k);j--){
            
            int cost=solve(j,k,arr,dp)+Math.abs(arr[j]-arr[i]);
            minCost=Math.min(minCost,cost);
            
        }
        return dp[i]=minCost;
    }
}
