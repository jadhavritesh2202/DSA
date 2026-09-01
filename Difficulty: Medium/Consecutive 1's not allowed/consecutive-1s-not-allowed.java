class Solution {
    
    int countStrings(int n) {
        // code here
       int[][] dp=new int[n+1][2];
       for(int[] ele:dp){
           Arrays.fill(ele,-1);
       }
       
        return  solve(n,0,dp);
        
    }
    public int solve(int idx,int prevOne,int[][] dp){
        if(idx==0){
            return 1;
        }
        if(dp[idx][prevOne]!=-1) return dp[idx][prevOne];
        int ans=solve(idx-1,0,dp);
        if(prevOne==0){
            ans+=solve(idx-1,1,dp);
        }
        return dp[idx][prevOne]=ans;
    }
}