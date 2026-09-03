class Solution {
    public boolean uniformArray(int[] nums1) {
        //find min
          int min=Integer.MAX_VALUE;
          for(int num:nums1){
            min=Math.min(min,num);
          }
         //smallest min is odd then wen can convert to odd
          if(min % 2 !=0) return true;

          //if all even in nums2

          for(int num:nums1){
            if(num%2!=0){
                return false;
            }
          }
          return true;

    }
}