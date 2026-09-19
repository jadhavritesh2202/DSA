class Solution {
    int[][] dp;
    public int findMinCost(String s1, String s2, int costS1, int costS2) {
        // code here
        int n=s1.length();
        int m=s2.length();
         dp=new int[n][m];
         for(int[] ele:dp){
             Arrays.fill(ele,-1);
         }
        int lcsLength=findCost(n-1,m-1,s1,s2);
        
        return (n-lcsLength)*costS1 + (m-lcsLength)*costS2;
    }
    private int findCost(int i,int j,String s1,String s2){
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)) {
            return dp[i][j]=1+findCost(i-1,j-1,s1,s2);
        }
        return dp[i][j]=Math.max(findCost(i-1,j,s1,s2),findCost(i,j-1,s1,s2));
    }
    
}