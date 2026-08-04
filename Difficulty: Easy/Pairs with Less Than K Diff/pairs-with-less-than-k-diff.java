class Solution {
	public static int countPairs(int arr[], int k) {
		// code here
		int n = arr.length;
		int cnt = 0;
		Arrays.sort(arr);
		int sum = 0;
		int i = 0;
		for (int j = 0; j<n; j++) {
		    //shrink it
			while (arr[j]-arr[i]>=k) {
				i++;
			}
			
			cnt+=j-i;
		}
		return cnt;
	}
}
