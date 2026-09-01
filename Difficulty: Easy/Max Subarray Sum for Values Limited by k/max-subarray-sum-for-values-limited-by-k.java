class Solution {
    public int maxSum(int[] arr, int k) {
        // code here
        int n=arr.length;
        int j=0;
        int res=0;
        int sum=0;
        while(j<n){
            if(arr[j]<=k){
                sum+=arr[j];
            }else{
                sum=0;
            }
            res=Math.max(res,sum);
            j++;
            
        }
        return res;
    }
}