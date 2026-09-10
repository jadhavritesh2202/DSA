class Solution {
    int[] arr;
    int[][] dp;
    public int lis(int arr[]) {
        // code here
        this.arr=arr;
        int n=arr.length;
        dp=new int[n][n+1];
        for(int[] ele:dp){
            Arrays.fill(ele,-1);
        }
        return solve(0,-1);
        
        
    }
    public int solve(int idx,int prev){
        if(idx==arr.length) return 0;
        if(dp[idx][prev+1]!=-1) return dp[idx][prev+1];
        int notTake=0+solve(idx+1,prev);
        int take=0;
        
        if(prev==-1 || arr[idx]>arr[prev]){
            take=1+solve(idx+1,idx);
        }
        
        return dp[idx][prev+1]=Math.max(notTake,take);
    }
}