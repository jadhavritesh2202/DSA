class Solution {
      public int perfectSum(int[] nums, int target) {

        int n = nums.length;
        int[][] dp = new int[n][target + 1];

        // Base Case
        if (nums[0] == 0)
            dp[0][0] = 2;          // {} and {0}
        else
            dp[0][0] = 1;          // {}

        if (nums[0] != 0 && nums[0] <= target)
            dp[0][nums[0]] = 1;

        for (int idx = 1; idx < n; idx++) {
            for (int sum = 0; sum <= target; sum++) {

                int notPick = dp[idx - 1][sum];

                int pick = 0;
                if (nums[idx] <= sum) {
                    pick = dp[idx - 1][sum - nums[idx]];
                }

                dp[idx][sum] = notPick + pick;
            }
        }
        return dp[n-1][target];
      }

    public int countPartitions(int[] arr, int diff) {
        // code here
          int sum=0;
          for(int num:arr){
              sum+=num;
          }
          if((sum-diff)<0 || (sum-diff) % 2!=0){
              return 0;
          }
          return perfectSum(arr, (sum-diff)/2);
    }
}
