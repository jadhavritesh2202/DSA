class Solution {
    static int smallestSumSubarray(int a[], int size) {
        // your code here
        int minSum=Integer.MAX_VALUE;
        int sum=0;
        
        for(int i=0;i<size;i++){
            if(sum<=0){
                sum+=a[i];
                minSum=Math.min(minSum,sum);
            }else{
                sum=a[i];
                minSum=Math.min(minSum,sum);
            }
        }
        return minSum;
    }
}