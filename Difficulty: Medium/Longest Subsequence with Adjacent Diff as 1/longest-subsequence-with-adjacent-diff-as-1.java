class Solution {
    public int longestSubseq(int[] arr) {

        HashMap<Integer, Integer> dp = new HashMap<>();

        int ans = 0;

        for (int x : arr) {

            int take = 1;

            if (dp.containsKey(x - 1)) {
                take = Math.max(take, dp.get(x - 1) + 1);
            }

            if (dp.containsKey(x + 1)) {
                take = Math.max(take, dp.get(x + 1) + 1);
            }

            dp.put(x, Math.max(dp.getOrDefault(x, 0), take));

            ans = Math.max(ans, dp.get(x));
        }

        return ans;
    }
}