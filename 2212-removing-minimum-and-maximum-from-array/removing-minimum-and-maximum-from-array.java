class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int minIdx = 0;
        int maxIdx = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] < min) {
                min = nums[i];
                minIdx = i;
            }

            if (nums[i] > max) {
                max = nums[i];
                maxIdx = i;
            }
        }

        // Delete both from front and back
        int both = (Math.min(minIdx, maxIdx) + 1)
                 + (n - Math.max(minIdx, maxIdx));

        // Delete both from front
        int front = Math.max(minIdx, maxIdx) + 1;

        // Delete both from back
        int back = n - Math.min(minIdx, maxIdx);

        return Math.min(both, Math.min(front, back));
    }
}