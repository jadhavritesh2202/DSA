class Solution {
    static boolean isSubsetSum(int arr[], int sum) {
        // code here
        int n=arr.length;
        int[][] dp=new int[n][sum+1];
        
         for(int[] ele:dp){
             Arrays.fill(ele,-1);
         }
         
         return helper(n-1,sum,arr,dp);
         
    }
    public static boolean helper(int idx,int tar,int[] arr,int[][] dp){
        if(tar==0) return true;
        if(idx==0) return arr[0]==tar;
        
        if(dp[idx][tar]!=-1) return dp[idx][tar]==1;
        
        //not take
        boolean notTake=helper(idx-1,tar,arr,dp);
        boolean Take=false;
          if(tar >= arr[idx]){
              Take=helper(idx-1,tar-arr[idx],arr,dp);
          }
          
        dp[idx][tar]=(notTake||Take)? 1 : 0;
        
        return Take||notTake;
    }
}