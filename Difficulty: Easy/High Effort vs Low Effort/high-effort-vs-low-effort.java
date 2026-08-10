class Solution {
    int[][] dp;
    public int maxTask(int[] h, int[] l) {
        // code here
        int n=h.length;
        dp=new int[n][2];
        for(int[] e:dp){
            Arrays.fill(e,-1);
        }
        return solve(0,false,h,l);
        
    }
    private int solve(int i,boolean prevTask,int[] h,int[] l){
        //base case
        if(i==h.length){
            return 0;
        }
        int state=prevTask ? 1:0;
        if(dp[i][state]!=-1) return dp[i][state];
        
        //do nothing
        int skip=solve(i+1,false,h,l);
        //low task
        int low=l[i]+solve(i+1,true,h,l);
        //high task
        int high=0;
        if(!prevTask){
            high=h[i]+solve(i+1,true,h,l);
        }
        
        return dp[i][state]=Math.max(skip,Math.max(low,high));
    }
}