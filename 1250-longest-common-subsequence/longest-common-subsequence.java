class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
          int n=text1.length();
          int m=text2.length();
         int[][] dp=new int[n][m];
         for(int[] ele:dp){
            Arrays.fill(ele,-1);
         }
          return helper(n-1,m-1,dp,text1,text2);

    }
    public int helper(int i,int j,int[][] dp,String s1, String s2){
        if(i<0 || j<0) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j]=1+helper(i-1,j-1,dp,s1,s2);
        }

        return dp[i][j]=Math.max(helper(i-1,j,dp,s1,s2),helper(i,j-1,dp,s1,s2));

    }
}