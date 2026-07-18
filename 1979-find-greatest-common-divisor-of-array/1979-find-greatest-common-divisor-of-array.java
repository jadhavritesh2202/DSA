class Solution {
    public int findGCD(int[] nums) {
        
        int max=0;
        int min=Integer.MAX_VALUE;
        for(int num:nums){
            max=Math.max(max,num);
            min=Math.min(min,num);
        }
        int res=1;
        for(int i=max;i>1;i--){
            if(max % i==0 && min % i==0){
                  res=i;
                  break;
            }
        }
        return res;

    }
}