class Solution {
    public int maxPathSum(int[] a, int[] b) {
        // code here
        
        
        int n = a.length;
        int m = b.length;

        int i = 0, j = 0;
        int sum1 = 0, sum2 = 0;
        int ans = 0;

        while(i<n && j<m){
            if(a[i]<b[j]){
                sum1+=a[i];
                i++;
            }else if(a[i]>b[j]){
                 sum2+=b[j];
                 j++;
            }else{
                //for equal
                ans+=Math.max(sum1,sum2)+a[i];//a[i] for common
                sum1=0;
                sum2=0;
                i++;j++;
                
            }
        }
        
          while (i < n)
            sum1 += a[i++];

        while (j < m)
            sum2 += b[j++];

        ans += Math.max(sum1, sum2);

        return ans;
        
    }
}