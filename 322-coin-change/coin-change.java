class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        //for idx=0
        for(int tar=0;tar<=amount;tar++){
              if(tar % coins[0]==0){
                dp[0][tar]=tar/coins[0];
              }else{
                dp[0][tar]=Integer.MAX_VALUE;
              }
        }

        for(int idx=1;idx<n;idx++){
            for(int tar=0;tar<=amount;tar++){
                int notTake=0+dp[idx-1][tar];
                int take=Integer.MAX_VALUE;
                if(coins[idx]<=tar){
                    if(dp[idx][tar-coins[idx]]!=Integer.MAX_VALUE){
                        take=1+dp[idx][tar-coins[idx]];
                    }
                }
                dp[idx][tar]=Math.min(take,notTake);

            }
        }
        return dp[n-1][amount]==Integer.MAX_VALUE ? -1 : dp[n-1][amount];
    }
}