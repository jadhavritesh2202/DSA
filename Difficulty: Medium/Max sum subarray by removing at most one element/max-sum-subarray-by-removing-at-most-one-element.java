class Solution {
    public int maxSumSubarray(int[] arr) {
        // code here
        int n=arr.length;
        
        if (n == 1)
            return arr[0];
        int[] prefix=new int[n];
        int[] suffix=new int[n];
        
        prefix[0]=arr[0];
        suffix[n-1]=arr[n-1];
        
         int ans = arr[0];
        for(int i=1;i<n;i++){
              prefix[i]=Math.max(arr[i],prefix[i-1]+arr[i]);
               ans = Math.max(ans, prefix[i]);
        }
        
        for(int i=n-2;i>=0;i--){
            suffix[i]=Math.max(arr[i],suffix[i+1]+arr[i]);
        }
        
       
          // Try removing each element
        for (int i = 1; i < n - 1; i++) {
            ans = Math.max(ans, prefix[i - 1] + suffix[i + 1]);
        }

        return ans;
    }
}