class Solution {
    int[] dp;
    public int getMinSteps(int n) {
        // code here
        //  if(n==1) return 0;
          dp=new int[n+1];
         
        //  int ans=getMinSteps(n-1);
        //  if(n%2==0){
        //      ans=Math.min(ans,getMinSteps(n/2));
        //  }
        //  if(n%3==0){
        //   ans=Math.min(ans,getMinSteps(n/3));
        //  }
         
        //  return 1+ans;
        
        Arrays.fill(dp, -1);

        return solve(n);
    }
    public int solve(int idx){
        if(idx==1) return 0;
        
        if(dp[idx]!=-1) return dp[idx];
        
        int ans=solve(idx-1);
        
        if(idx%2==0){
            ans=Math.min(ans,solve(idx/2));
        }
         if(idx%3==0){
            ans=Math.min(ans,solve(idx/3));
        }
        
        return dp[idx]=1+ans;
    }
}