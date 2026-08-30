class Solution {
	public ArrayList<Integer> getMarks(int[] l, int[] r, int[] rank) {
		// code here
		//  ArrayList<Integer> ans=new ArrayList<>();
		ArrayList<Integer> store = new ArrayList<>();
		int n = l.length;
		int i = 0;
		while (i<n) {
			
			for (int k = l[i]; k <= r[i]; k++) {
				store.add(k);
			}
			i++;
		}
		
		ArrayList<Integer> ans = new ArrayList<>();
		
		// Answer every query using direct indexing
		for (int j = 0; j < rank.length; j++) {
			ans.add(store.get(rank[j] - 1));
		}
		
		return ans;
		
	}
}
