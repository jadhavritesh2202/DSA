class Solution {
    int maxIndexDiff(int[] arr) {
        // code here
        
        int n=arr.length;
        int[] right=new int[n];
        right[n-1] = arr[n-1];
        for(int i=n-2;i>=0;i--){
            right[i]=Math.max(right[i+1],arr[i]);
        }
        
        int ans=Integer.MIN_VALUE;
        int i=0,j=0;
        while(j<n){
            if(right[j]>=arr[i]){
                ans=Math.max(ans,j-i);
                j++;
            }else{
                i++;
            }
        }
        return ans;
        
    }
}