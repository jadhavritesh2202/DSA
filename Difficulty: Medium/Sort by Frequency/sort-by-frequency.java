class Solution {
	public String frequencySort(String s) {
		// code here
		int n = s.length();
		HashMap<Character, Integer> map = new HashMap<>();
		for (char ch:s.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		ArrayList<Character> list = new ArrayList<>(map.keySet());
		Collections.sort(list, (a, b)->{
		if (map.get(a).equals(map.get(b))) {
			return Character.compare(a, b);
		}
		return Integer.compare(map.get(a), map.get(b));
		});
		
		StringBuilder sb = new StringBuilder();
		for (char ch:list) {
			for (int i = 0; i<map.get(ch); i++) {
				sb.append(ch);
			}
		}
		return sb.toString();
	}
};
