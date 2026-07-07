class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int prev=nums[0];
        int prev2=0;
        int curr=0;
        for(int i=1;i<n;i++){
            int pick=nums[i];
            if(i>1){
                pick+=prev2;
            }
            int notpick=0+prev;
            curr=Math.max(pick,notpick);
            prev2=prev;
            prev=curr;
        }
        return curr;
    }
}