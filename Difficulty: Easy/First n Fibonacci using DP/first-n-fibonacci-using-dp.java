class Solution {
    ArrayList<Integer> fibonacciNumbers(int n) {
        // code here
           int mod = 1000000007;
        ArrayList<Integer> list=new ArrayList<>();
         int[] dp=new int[n+1];
         
         dp[0]=0;
         dp[1]=1;
         
         for(int i=2;i<=n;i++){
             dp[i]=(dp[i-1]+dp[i-2])% mod;
         }
         for(int ele:dp){
             list.add(ele);
         }
         return list;
         
    }
}