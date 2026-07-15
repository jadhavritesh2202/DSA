class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumOdd=0;
        int sumEven=0;
        for(int i=1;i<=n;i++){
           
                sumEven+=2*i;
           
                sumOdd+=2*i-1;
            
        }
         int ans=0;
        for(int i=n;i>=0;i--){
            if(sumOdd % i ==0 && sumEven % i ==0){
               ans=i;
               break;
            }
        }
        return ans;
    }
}