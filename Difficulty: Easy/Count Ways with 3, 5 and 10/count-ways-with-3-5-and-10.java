class Solution {
	public int countWays(int n) {
		// code here
		int[] dp = new int[n + 1];
		int[] scores = {3, 5, 10};
		dp[0] = 1;
		for (int ele:scores) {
			for (int i = ele; i <= n; i++) {
				dp[i]+=dp[i-ele];
			}
		}
		return dp[n];
	}
}
