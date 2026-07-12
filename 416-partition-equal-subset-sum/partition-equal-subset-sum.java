class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0)
            return false;
        int k = sum / 2;
        //create dp
        boolean[][] dp = new boolean[n][k + 1];
        return helper(k, dp, nums,n);
    }

    public boolean helper(int tar, boolean[][] dp, int[] nums,int n) {
        //base cases
        for (int i = 0; i < n; i++) {
              dp[i][0] = true;
        }
        //base case
        if (nums[0] <= tar) {
            dp[0][nums[0]] = true;
        }
        //apply stuffs
        for (int idx = 1; idx < n; idx++) {
            for (int target = 1; target <= tar; target++) {
                boolean notpick = dp[idx - 1][target];
                boolean pick = false;
                if (target >= nums[idx]) {
                    pick = dp[idx - 1][target - nums[idx]];

                }
                dp[idx][target] = pick || notpick;
            }
            
        }
        return dp[n-1][tar];
      
    }
}