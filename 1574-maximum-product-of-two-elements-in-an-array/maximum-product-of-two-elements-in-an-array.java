class Solution {
    public int maxProduct(int[] nums) {
        //first find max of first two element
            int i=Integer.MIN_VALUE;
            int j=Integer.MIN_VALUE;

          for(int num:nums){
              if(num>=i){
                j=i;
                i=num;
              }else if(num>j){
                j=num;
              }
          }
           
           return (i-1) * (j-1);
    }
}