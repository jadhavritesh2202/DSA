class Solution {
    int[] dp;
	public int maximizeCuts(int n, int x, int y, int z) {
		// code here
			dp=new int[n+1];
		Arrays.fill(dp,-1);
		int ans = solve(n, x, y, z);
	
		return ans < 0 ? 0 : ans;
		
	}
	public int solve(int idx, int x, int y, int z) {
		
		if(idx==0) return 0;
		if (idx<0)
			return Integer.MIN_VALUE;
			
		if(dp[idx]!=-1) return dp[idx];	
			
		int first = 1 + solve(idx - x, x, y, z);
		int second = 1 + solve(idx - y, x, y, z);
		int third = 1 + solve(idx - z, x, y, z);
		dp[idx]=Math.max(first, Math.max(second, third));
		return Math.max(first, Math.max(second, third));
	}
}
