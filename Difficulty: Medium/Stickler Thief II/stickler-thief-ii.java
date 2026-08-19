class Solution {
    public int maxValue(int[] arr) {
        // code here
        int n=arr.length;
        ArrayList<Integer> first=new ArrayList<>();
        ArrayList<Integer> second=new ArrayList<>();
        
        
        for(int i=0;i<n;i++){
            if(i!=0) first.add(arr[i]);
            if(i!=n-1) second.add(arr[i]);
        }
        return Math.max(solve(first),solve(second));
        
        
        
    }
    public int solve(ArrayList<Integer> list){
        int n=list.size();
        int[] dp=new int[n];
        dp[0]=list.get(0);
        for(int i=1;i<n;i++){
            int take=list.get(i);
            if(i>1){
                take+=dp[i-2];
            }
            int notTake=dp[i-1];
            dp[i]=Math.max(take,notTake);
        }
        return dp[n-1];
    }
    
}
