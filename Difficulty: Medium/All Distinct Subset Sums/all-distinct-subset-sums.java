class Solution {
    int[][] dp;
	public List<Integer> distinctSum(int[] nums) {
		// code here
		int n = nums.length;
		int total=0;
		for(int x:nums){
		    total+=x;
		}
		Set<Integer> set = new HashSet<>();
		dp=new int[n+1][total+1];
		for(int[] ele:dp){
		    Arrays.fill(ele,-1);
		}
		solve(n - 1, 0, nums, set);
		List<Integer> ans = new ArrayList<>(set);
		
		Collections.sort(ans);
		
		return ans;
	}
	public void solve(int idx, int sum, int[] nums, Set<Integer> set) {
		if (idx<0) {
			set.add(sum);
			return;
		}
		
		if(dp[idx][sum]!=-1) return;
		
		solve(idx - 1, sum, nums, set);
		solve(idx - 1, sum + nums[idx], nums, set);
		
		dp[idx][sum]=1;
		
	}
}
