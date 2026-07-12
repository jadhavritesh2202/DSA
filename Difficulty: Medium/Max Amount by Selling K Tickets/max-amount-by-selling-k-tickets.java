class Solution {
	public int maxAmount(int[] arr, int k) {
		// code here
		final int MOD = 1000000007;
		int n = arr.length;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		for (int num:arr) {
			pq.add(num);
		}
		long earn = 0;
		int i = 1;
		while (i <= k && !pq.isEmpty()) {
			int x = pq.poll(); 
			earn = (earn + x)%MOD;
			x--;
			
			if (x > 0) {
				pq.offer(x); 
			}
			i++;
		}
		return (int)earn;
		
	}
}
