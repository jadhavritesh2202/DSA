class Solution {
    int maxSubarraySum(int[] arr) {
        // Code here
        int subSum=Integer.MIN_VALUE;
        int sum=0;
        
        for(int i=0;i<arr.length;i++){
            if(sum>=0){
                sum+=arr[i];
                subSum=Math.max(subSum,sum);
            }else{
                sum=arr[i];
                subSum=Math.max(subSum,sum);
            }
        }
        return subSum;
        
    }
}
