class Solution {
    public int maxFruits(ArrayList<Integer> arr, int m) {
        // code here
      int n=arr.size();
      if(m>=n){
          int sum=0;
          for(int num:arr){
              sum+=num;
          }
          return sum;
      }
      
      int sum=0;
      int ans=Integer.MIN_VALUE;
      for(int i=0;i<m;i++){
          sum+=arr.get(i);
      }
      ans=sum;
      
    for (int i = m; i < n + m - 1; i++) {
           sum += arr.get(i % n);
           sum -= arr.get((i - m) % n);

           ans = Math.max(ans, sum);
       }

       return ans;
    }
}