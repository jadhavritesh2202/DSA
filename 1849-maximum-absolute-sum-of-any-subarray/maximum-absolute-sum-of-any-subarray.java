class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n=nums.length;
        int currMax=nums[0];
        int maxSum=nums[0];
        for(int i=1;i<n;i++){
              currMax=Math.max(nums[i],currMax+nums[i]);
              maxSum=Math.max(maxSum,currMax);
        }
        int currMin=nums[0];
        int minSum=nums[0];
         for(int i=1;i<n;i++){
              currMin=Math.min(nums[i],currMin+nums[i]);
              minSum=Math.min(minSum,currMin);
        }
        return Math.max((maxSum),Math.abs(minSum));

    }
}