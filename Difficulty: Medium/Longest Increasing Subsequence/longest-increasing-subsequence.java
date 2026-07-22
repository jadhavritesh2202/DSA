class Solution {
    static int lis(int arr[]) {
        // code here
        int n=arr.length;
        int[][] dp=new int[n][n+1];
        for(int[] ele:dp){
            Arrays.fill(ele,-1);
        }
        return helper(0,-1,dp,n,arr);
        
    }
    public static int helper(int idx,int prevIdx,int[][] dp,int n,int[] arr){
          if(idx==n) return 0;
          
          if(dp[idx][prevIdx+1]!=-1) return dp[idx][prevIdx+1];
          
          //not take
          int len=0+helper(idx+1,prevIdx,dp,n,arr);
          
          if(prevIdx==-1 || arr[idx] > arr[prevIdx]){
             len=Math.max(len,1+helper(idx+1,idx,dp,n,arr));
          //   dp[idx][prevIdx+1]=len;
          }
         return dp[idx][prevIdx+1]=len;
    }
}