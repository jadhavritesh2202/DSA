class Solution {
	public boolean isPossible(int[] arr, int s, int x) {
		// code here
	//	int n = arr.length;
		long sum = s;
		ArrayList<Long> list = new ArrayList<>();
		list.add((long)s);
		for (int num:arr) {
		  long next=sum+num;
		  
		  if(next>x) break;
		  list.add(next);
		  sum+=next;
		}
		long target = x;
		for (int i = list.size() - 1; i >= 0; i--) {
			if (list.get(i) <= target) {
				target -= list.get(i);
			}
			if (target == 0)
				return true;
		}
		return false;
		
	}
}
