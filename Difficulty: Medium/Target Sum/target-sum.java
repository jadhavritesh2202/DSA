
import java.util.Arrays;

class Solution {

    int solve(int idx, int target, int[] nums, int[][] dp, int offset, int totalSum) {

        // Base Case
        if (idx == nums.length) {
            return target == 0 ? 1 : 0;
        }

        // Target out of possible range
        if (target < -totalSum || target > totalSum) {
            return 0;
        }

        // Already computed
        if (dp[idx][target + offset] != -1) {
            return dp[idx][target + offset];
        }

        // Put '+' before nums[idx]
        int add = solve(idx + 1, target - nums[idx], nums, dp, offset, totalSum);

        // Put '-' before nums[idx]
        int subtract = solve(idx + 1, target + nums[idx], nums, dp, offset, totalSum);

        return dp[idx][target + offset] = add + subtract;
    }

    public int totalWays(int[] nums, int target) {

        int totalSum = 0;
        for (int x : nums)
            totalSum += x;

        // Impossible
        if (Math.abs(target) > totalSum)
            return 0;

        int offset = totalSum;

        int[][] dp = new int[nums.length][2 * totalSum + 1];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return solve(0, target, nums, dp, offset, totalSum);
    }
}