class Solution {
    public void rotateclockwise(int[] arr, int k) {
        // code here
        int n=arr.length;
          k = k % n;          // Handle k > n
        int k1 = n - k;
        
        reverse(0,k1-1,arr);
        reverse(k1,n-1,arr);
        reverse(0,n-1,arr);
        
        
    
    }
    public void reverse(int start,int end,int[] arr){
        while(start < end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;end--;
        }
    }
}