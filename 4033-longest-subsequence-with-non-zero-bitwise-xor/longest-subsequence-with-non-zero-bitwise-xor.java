class Solution {
    public int longestSubsequence(int[] nums) {
        int n=nums.length;
        boolean allZero=true;
        int xor=0;

        for(int num:nums){
            xor=(xor^num);

            if(num!=0){
                allZero=false;
            }
        }
        if(allZero){
            return 0;
        }
       return xor==0?n-1:n;
    }
}