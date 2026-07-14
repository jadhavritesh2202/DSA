class Solution {
	
	public int minCoins(int coins[], int sum) {
		// code here
		int n = coins.length;
		int[][] dp = new int[n][sum + 1];
		
		// base case
		// what if arr[0] remaining so we check sum from 0 to sum
		for (int tar = 0; tar <= sum; tar++) {
			if (tar % coins[0] == 0) {
				dp[0][tar] = tar/coins[0];
			} else {
				dp[0][tar] = Integer.MAX_VALUE;
			}
		}
		
		// nested loop
		for (int idx = 1; idx<n; idx++) {
			for (int tar = 0; tar <= sum; tar++) {
				int notTake = 0 + dp[idx - 1][tar];
				int take = Integer.MAX_VALUE;
				if (coins[idx] <= tar) {
					if (dp[idx][tar - coins[idx]] != Integer.MAX_VALUE) {
						take = 1 + dp[idx][tar - coins[idx]];
					}
				}
				dp[idx][tar] = Math.min(take, notTake);
			}
		}
	return dp[n-1][sum] == Integer.MAX_VALUE ? -1 : dp[n-1][sum];
	}
}
