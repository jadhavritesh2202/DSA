class Solution {
    public int maxSum(int n) {
        // code here.
        
        //return Math.max(n,maxSum(n/2)+maxSum(n/3)+maxSum(n/5));
        return solve(n);
    }
    public int solve(int n){
        if(n==0) return 0;
        int broken=solve(n/2)+solve(n/3)+solve(n/4);
        return Math.max(n,broken);
    }
}
