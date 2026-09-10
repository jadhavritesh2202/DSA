class Solution {
	public int pairCount(int x, int y) {
		// code here
		if (y % x != 0)
			return 0;
		int cnt = 0;
		int n = y/x;
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				int j = n/i;
				if (gcd(i, j) == 1) {
					cnt++;
				}
			}
		}
		return cnt;
	}
	public int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a%b);
	}
}
