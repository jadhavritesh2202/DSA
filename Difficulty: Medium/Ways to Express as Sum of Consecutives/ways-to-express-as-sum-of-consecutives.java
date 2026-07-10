// class Solution {
//     int count=0;
//     public int getCount(int n) {
//         // code here
//         if(n<=2) return 0;
//         for(int start=1;start<n;start++){
//             dfs(start,start,n);
//         }
//         return count;
        
        
//     }
//     public void dfs(int start,int sum,int n){
//         if(sum==n){
//             count++;
//             return;
//         }
//         if(sum>n){
//             return;
//         }
//         dfs(start+1,sum+start+1,n);
//     }
// };

// class Solution {
    
//      public int getCount(int n) {
//         if(n==1) return 0;
//         int ans=0;
//         int i=1,j=1;
//         int sum=0;
//         while(j<=(n/2 + 1)){
//             sum=sum+j;
//             while(sum>n){
//                 sum=sum-i;
//                 i++;
//             }
//             if(sum==n){
//                 ans++;
//                 sum=sum-i;
//                 i++;
//             }
//             j++;
//         }
//         return ans;
//      }
// }

class Solution {
    public int getCount(int n) {
        int count = 0;
        for (int k = 2; k * (k + 1) / 2 <= n; k++) {
            int numerator = n - (k * (k - 1)) / 2;           
            if (numerator % k == 0) {
                int a = numerator / k;
                if (a > 0) {
                    count++;
                }
            }
        }        
        return count;
    }
}