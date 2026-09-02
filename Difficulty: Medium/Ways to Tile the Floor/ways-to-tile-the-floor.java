class Solution {
	static final int MOD = 1000000007;
	int m;
	public int countWays(int n, int m) {
		// code here
		this.m = m;
		long[] dp=new long[n+1];
		Arrays.fill(dp,-1);
		 return (int)solve(n,dp);
		
	}
	public long solve(int n,long[] dp) {
		if (n == 0)
			return 1;
		if(dp[n]!=-1) return dp[n];
		long left = solve(n - 1,dp);
		long right = 0;
		if (n >= m) {
			right = solve(n - m,dp);
			
		}
		return dp[n]=(left + right)%MOD;
	}
}
