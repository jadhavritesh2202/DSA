class Solution {
	public int largestArea(int n, int m, int[][] arr) {
		// code here
		List<Integer> row = new ArrayList<>();
		List<Integer> col = new ArrayList<>();
		for (int[] cell:arr) {
			row.add(cell[0]);
			col.add(cell[1]);
		}
		row.add(0);
		row.add(n + 1);
		col.add(0);
		col.add(m + 1);
		
		Collections.sort(row, (a, b) -> a - b);
		Collections.sort(col, (a, b) -> a - b);
		int r = row.get(0);
		int c = col.get(0);
		for (int i = 1; i<row.size(); i++) {
			r = Math.max(r, (row.get(i) - row.get(i-1) - 1));
		}
		
		for (int i = 1; i<col.size(); i++) {
		     c = Math.max(c, (col.get(i) - col.get(i-1) - 1));
		}
		return r*c;
	}
}
