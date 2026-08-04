class Solution {
    public static int smallestSubWithSum(int k, int[] arr) {
        // Your code goes here
        int n=arr.length;
        int i=0;
        int len=Integer.MAX_VALUE;
        int sum=0;
        for(int j=0;j<n;j++){
          sum+=arr[j];
          while(sum>k){
              len=Math.min(len,j-i+1);
              sum=sum-arr[i];
              i++;
          }
        }
        if(len==Integer.MAX_VALUE) return 0;
        return len;
    }
}
