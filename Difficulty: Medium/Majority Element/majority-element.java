class Solution {
	int majorityElement(int arr[]) {
		// code here
		int n = arr.length;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int num:arr) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int key = entry.getKey();
			int value = entry.getValue();
			
			if (value > n / 2) {
				return key;
			}
		}
		return - 1;
		
	}
}
