class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        return helper(n - 1, target, nums);
    }

    public int helper(int idx, int k, int[] arr) {
        if (idx == 0) {
            int count = 0;

            if (k - arr[0] == 0)
                count++;
            if (k + arr[0] == 0)
                count++;

            return count;
        }

        int neg = helper(idx - 1, k - arr[idx], arr);
        int pos = helper(idx - 1, k + arr[idx], arr);
        return neg + pos;
    }
}