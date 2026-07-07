class Solution {
	public int maximumPoints(int mat[][]) {
		// code here
		int n = mat.length;
		int[][] dp = new int[n][4];
		// fills as -1
		for (int[] a:dp) {
			Arrays.fill(a, -1);
		}
		return helper(n - 1, 3, mat, dp);
	}
	public int helper(int day, int last, int[][] arr, int[][] dp) {
		if (day == 0) {
			int maxi = 0;
			for (int task = 0; task<3; task++) {
				if (task != last) {
					maxi = Math.max(maxi, arr[0][task]);
				}
			}
			return maxi;
		}
		
		if (dp[day][last] != -1)
			return dp[day][last];
		
		int maxi = 0;
		for (int task = 0; task<3; task++) {
			if (task != last) {
				int points = arr[day][task]+helper(day-1,task,arr,dp);
				maxi=Math.max(maxi,points);
			}
		}
		return dp[day][last]=maxi;
	}
}
