class Solution {
    int[][] dp;
    public int count(int coins[], int sum) {
        // code here.
        int n=coins.length;
        dp=new int[n][sum+1];
        for(int[] ele:dp){
            Arrays.fill(ele,-1);
        }
        return solve(n-1,sum,coins);
        
    }
    public int solve(int idx,int tar,int[] arr){
        if(idx==0){
          return tar % arr[0] == 0 ? 1 : 0;
        }
        if(dp[idx][tar]!=-1) return dp[idx][tar];
        int notTake=solve(idx-1,tar,arr);
        int take=0;
        if(arr[idx]<=tar){
            take=solve(idx,tar-arr[idx],arr);
        }
        return dp[idx][tar]=take+notTake;
        
    }
}