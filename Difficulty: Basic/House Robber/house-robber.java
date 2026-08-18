class Solution {
    public int maximizeMoney(int n, int k) {
        // code here
        int[] dp=new int[n];
        dp[0]=k;
        
        for(int i=1;i<n;i++){
            int left=k;
            if(i>1){
                left+=dp[i-2];
            }
            int right=dp[i-1];
            
            dp[i]=Math.max(left,right);
        }
        return dp[n-1];
        
        
    }
}