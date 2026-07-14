class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];

        for(int tar=0;tar<=amount;tar++){
              if(tar % coins[0]==0)  dp[0][tar]=1;
              else  dp[0][tar]=0; 
        }

        for(int idx=1;idx<n;idx++){
            for(int tar=0;tar<=amount;tar++){
                int notTake=dp[idx-1][tar];
                int take=0;
                if(coins[idx]<=tar){
                    take=dp[idx][tar-coins[idx]];
                }
                dp[idx][tar]=take+notTake;
            }
        }
        return dp[n-1][amount];
    }
}