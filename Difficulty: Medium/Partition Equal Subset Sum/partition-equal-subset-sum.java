class Solution {
	static boolean equalPartition(int arr[]) {
		// code here
		int n = arr.length;
		if (n == 1)
			return false;
		int sum = 0;
		for (int num:arr) {
			sum += num;
		}
		
		// Odd sum cannot be divided equally
		if (sum % 2 != 0) {
			return false;
		}
		
		int target = sum / 2;
		
		boolean[][] dp = new boolean[n][target + 1];
		
		for (int i = 0; i<n; i++) {
			dp[i][0] = true;
		}
		
		// if idx==0 and it equal to target
		if (arr[0] <= target) {
			dp[0][arr[0]] = true;
		}
		for (int idx = 1; idx<n; idx++) {
			for (int tar = 1; tar <= target; tar++) {
				boolean notPick = dp[idx - 1][tar];
				boolean Pick = false;
				if (tar >= arr[idx]) {
					Pick = dp[idx - 1][tar - arr[idx]];
				}
				
				dp[idx][tar] = Pick || notPick;
			}
		}
		return dp[n - 1][target];
		
	}
}
