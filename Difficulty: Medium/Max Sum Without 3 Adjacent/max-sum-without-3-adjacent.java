class Solution {
    int[] dp;
    public int findMaxSum(int arr[]) {
        // code here
        dp=new int[arr.length];
        Arrays.fill(dp,-1);
        return solve(arr,arr.length);
        
    }
    public int solve(int[] arr,int idx){
        
        if(idx<=0) return 0;
        if(idx==1) return arr[0];
        if(idx==2) return arr[0]+arr[1];
        if(dp[idx-1]!=-1) return dp[idx-1];
        int skip=solve(arr,idx-1);
        int pickOne=arr[idx-1]+solve(arr,idx-2);
        int pickTwo=arr[idx-1]+arr[idx-2]+solve(arr,idx-3);
        
        return dp[idx-1]=Math.max(skip,Math.max(pickOne,pickTwo));
        
    }
}