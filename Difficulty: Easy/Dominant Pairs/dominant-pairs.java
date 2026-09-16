class Solution {
    public int dominantPairs(int[] arr) {
        // Code here
      
        int n=arr.length;
        
        // for(int i=0;i<n/2;i++){
        //     for(int j=n/2;j<n;j++){
        //         if(arr[i]>=5*arr[j]){
        //             cnt++;
        //         }
        //     }
        // }
        // return cnt;
        
        int mid=n/2;
        int[] left=Arrays.copyOfRange(arr,0,mid);
        int[] right=Arrays.copyOfRange(arr,mid,n);
        
        Arrays.sort(left);
        Arrays.sort(right);
        
        long cnt=0;
        int i=0;
        
        while(i<mid){
            int j=0;
            while(j<mid && (long)left[i]>=5*right[j]){
                j++;
                cnt++;
            }
            i++;
            
        }
        
        
        
        return (int)cnt;
    }
}