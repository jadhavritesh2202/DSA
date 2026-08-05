class Solution {
	public int countSubarray(int[] arr, int l, int r) {
		// code here
		int n = arr.length;
		int cnt1 = helper(arr, r);
		int cnt2 = helper(arr, l - 1);
		return cnt1 - cnt2;
	}
	public int helper(int[] arr, int x) {
		int n = arr.length;
		int cnt = 0; int sum = 0;
		int i = 0;
		for (int j = 0; j<n; j++) {
			sum += arr[j];
				
			
			while (sum>x) {
				sum = sum - arr[i];
				i++;
			}
			cnt += j - i + 1;
		}
		return cnt;
	}
}
