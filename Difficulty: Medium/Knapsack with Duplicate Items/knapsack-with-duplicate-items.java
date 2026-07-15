class Solution {
    public int knapSack(int val[], int wt[], int W) {
        // code here
        int n=wt.length;
        int[][] dp=new int[n][W+1];
        
        //base case
        for(int wgt=0;wgt<=W;wgt++){
            dp[0][wgt]=(wgt/wt[0])*val[0];
        }
        
        for(int idx=1;idx<n;idx++){
            for(int wgt=0;wgt<=W;wgt++){
                int notTake=0+dp[idx-1][wgt];
                int take=Integer.MIN_VALUE;
                if(wt[idx]<=wgt){
                    take=val[idx]+dp[idx][wgt-wt[idx]];
                }
                dp[idx][wgt]=Math.max(take,notTake);
            }
        }
        return dp[n-1][W];
        
    }
}