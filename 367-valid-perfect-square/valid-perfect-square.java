class Solution {
    public boolean isPerfectSquare(int num) {
        if(num<2) return true;
          int l=2;int h=num/2;
          while(l<=h){
            int mid=l+(h-l)/2;
            long square = (long) mid * mid;
            if(square==num){
                return true;
            }else if(square>num){
                h=mid-1;
            }else{
                l=mid+1;
            }
          }
          return false;
    }
}