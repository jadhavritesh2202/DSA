class Triple {
	int start;
	int end;
	int pos;
	Triple(int start, int end, int pos) {
		this.start = start;
		this.end = end;
		this.pos = pos;
	}
}
class Solution {
	public ArrayList<Integer> maxMeetings(int[] s, int[] f) {
		// code here
		int n = s.length;
		ArrayList<Triple> list = new ArrayList<>();
		
		for (int i = 0; i<n; i++) {
			list.add(new Triple(s[i], f[i], i + 1));
		}
		
		list.sort((a, b) -> {
			if (a.end != b.end)
				return a.end - b.end;
			return a.pos - b.pos;
		});
		
		ArrayList<Integer> res = new ArrayList<>();
		
		int end = list.get(0).end;
		res.add(list.get(0).pos);
		
		for (int i = 1; i<n; i++) {
			if (list.get(i).start > end) {
				res.add(list.get(i).pos);
				end = list.get(i).end;
			}
		}
		Collections.sort(res);
		return res;
		
	}
}
