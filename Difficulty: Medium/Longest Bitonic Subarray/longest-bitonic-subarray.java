class Solution {
    public int bitonic(int[] arr) {
        // code here
        int n=arr.length;
        
        int[] incr=new int[n];
        int[] decr=new int[n];
        incr[0]=1;
        decr[n-1]=1;
        
        for(int i=1;i<n;i++){
            if(arr[i]>=arr[i-1]){
                incr[i]=incr[i-1]+1;
            }else{
                incr[i]=1;
            }
        }
        
        for(int i=n-2;i>=0;i--){
            if(arr[i]>=arr[i+1]){
                decr[i]=decr[i+1]+1;
            }else{
                decr[i]=1;
            }
        }
        int res=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            res=Math.max(res,incr[i]+decr[i]-1);
        }
        return res;
    }
}