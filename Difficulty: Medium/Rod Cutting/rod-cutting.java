class Solution {
    public int cutRod(int[] price) {
        // code here
        int N=price.length;
        
        int[][] dp=new int[N][N+1];
        
        for(int n=0;n<=N;n++){
            dp[0][n]=n * price[0];
        }
        
        for(int idx=1;idx<N;idx++){
            for(int n=0;n<=N;n++){
                int notTake=0+dp[idx-1][n];
                int take=Integer.MIN_VALUE;
                int rodLen=idx+1;
                if(rodLen<=n){
                    take=price[idx]+dp[idx][n-rodLen];
                }
                dp[idx][n]=Math.max(take,notTake);
            }
        }
        return dp[N-1][N];
        
        
        
        
    }
}