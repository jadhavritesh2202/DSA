class Solution {
    int maxPeopleDefeated(int p) {
        // code here
        
        int l=0;
        int h=1000;
        int ans=0;
        while(l<=h){
            int mid=l+(h-l)/2;
              int sum = mid * (mid + 1) / 2;
              sum = sum * (2 * mid + 1) / 3;
            
            if(sum<=p){
                ans=mid;
                l=mid+1;
            }else{
                h=mid-1;
            }
            
        }
        return ans;
        
    }
};