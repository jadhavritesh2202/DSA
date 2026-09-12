class Solution {

    int[][] maxDp;
    int[][] minDp;

    public int maxProduct(int[] arr, int k) {
        int n = arr.length;

        maxDp = new int[n][k + 1];
        minDp = new int[n][k + 1];

        for (int i = 0; i < n; i++) {
            java.util.Arrays.fill(maxDp[i], Integer.MIN_VALUE);
            java.util.Arrays.fill(minDp[i], Integer.MAX_VALUE);
        }

        return solve(arr, n - 1, k)[0];
    }

    int[] solve(int[] arr, int idx, int k) {

        // k elements select
        if (k == 0) {
            return new int[]{1, 1};
        }

        // impossible
        if (idx < 0 || idx + 1 < k) {
            return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE};
        }

        // memo
        if (maxDp[idx][k] != Integer.MIN_VALUE) {
            return new int[]{maxDp[idx][k], minDp[idx][k]};
        }

        // Don't take
        int[] notTake = solve(arr, idx - 1, k);

        // Take
        int[] take = solve(arr, idx - 1, k - 1);

        int takeMax = Math.max(
            arr[idx] * take[0],
            arr[idx] * take[1]
        );

        int takeMin = Math.min(
            arr[idx] * take[0],
            arr[idx] * take[1]
        );

        int max = Math.max(notTake[0], takeMax);
        int min = Math.min(notTake[1], takeMin);

        maxDp[idx][k] = max;
        minDp[idx][k] = min;

        return new int[]{max, min};
    }
}