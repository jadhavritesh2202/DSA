class Solution {
	int[] coins;
	int[][][] dp;
	public boolean makeChanges(int k, int target, int[] coins) {
		// code here
		this.coins = coins;
		int n = coins.length;
		dp=new int[n][k+1][target+1];
		for(int i=0;i<n;i++){
		    for(int j=0;j<=k;j++){
		        Arrays.fill(dp[i][j],-1);
		    }
		}  
		return solve(n - 1, k, target);
	}
	public boolean solve(int idx, int k, int target) {
		if (k == 0) {
			return target == 0;
		}
		if (idx<0)	return false;
		if (dp[idx][k][target] != -1) {
             return dp[idx][k][target] == 1;
         }
		boolean notTake = solve(idx - 1, k, target);
		boolean Take = false;
		if (coins[idx] <= target) {
			Take = solve(idx, k - 1, target - coins[idx]);
		}
		dp[idx][k][target]=Take||notTake?1:0;
		return Take || notTake;
		
	}
}
