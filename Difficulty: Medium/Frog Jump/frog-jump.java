class Solution {
    int minCost(int[] height) {
        // code here
        int n=height.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return jump(n-1,height,dp);
    }
    int jump(int idx,int[] arr,int[] dp){
        if(idx==0) return 0;
        
        if(dp[idx]!=-1) return dp[idx];
        
        int left=jump(idx-1,arr,dp)+Math.abs(arr[idx]-arr[idx-1]);
        int right=Integer.MAX_VALUE;
        if(idx>1){
            right=jump(idx-2,arr,dp)+Math.abs(arr[idx]-arr[idx-2]);
        }
        
        return dp[idx]=Math.min(left,right);
        
    }
}