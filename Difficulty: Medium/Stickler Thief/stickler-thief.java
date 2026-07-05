class Solution {
    public int findMaxSum(int arr[]) {
        // code here
        int n=arr.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return fun(n-1,dp,arr);
    }
    public int fun(int idx,int[] dp,int[] arr){
        if(idx==0) return arr[idx];
        if(idx<0) return 0;
        
        if(dp[idx]!=-1) return dp[idx];
        
        int Pick= arr[idx] + fun(idx-2,dp,arr);
        int notPick=0 + fun(idx-1,dp,arr);
        dp[idx]=Math.max(Pick,notPick);
        return dp[idx];
    }
}