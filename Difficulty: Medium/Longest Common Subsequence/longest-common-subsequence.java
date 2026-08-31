class Solution {
    public int lcs(String s1, String s2) {
        // code here
        int n=s1.length();
        int m=s2.length();
        int[][] dp=new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(n-1,m-1,s1,s2,dp);
     
        
    }
    public int solve(int idx1,int idx2,String s1,String s2, int[][] dp){
        if(idx1<0 || idx2<0) return 0;
        if(dp[idx1][idx2]!=-1) return dp[idx1][idx2];
        if(s1.charAt(idx1)==s2.charAt(idx2)){
             return dp[idx1][idx2]=1+solve(idx1-1,idx2-1,s1,s2,dp);
        }
        return dp[idx1][idx2]=0+Math.max(solve(idx1-1,idx2,s1,s2,dp) , solve(idx1,idx2-1,s1,s2,dp));
    }
}