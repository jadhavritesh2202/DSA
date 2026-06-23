class Pair {
	int num;
	int freq;
	
	Pair(int num, int freq) {
		this.num = num;
		this.freq = freq;
	}
}
class Solution {
	public ArrayList<Integer> topKFreq(int[] arr, int k) {
		// Code here
		HashMap<Integer, Integer> freq = new HashMap<>();
		for (int i = 0; i<arr.length; i++) {
			freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
		}
		
		PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)-> {
			
			if (a.freq == b.freq) {
				return a.num - b.num; // smaller number has lower priority
			}
			
			return a.freq - b.freq; // smaller frequency at top
		});
		
		
		for(int key:freq.keySet()){
		    pq.add(new Pair(key,freq.get(key)));
		    
		    if(pq.size()>k){
		        pq.remove();
		    }
		}
		ArrayList<Integer> res=new ArrayList<>();
		for(int i=k-1;i>=0;i--){
		    res.add(0,pq.remove().num);
		    }
		 
		  return res;
		
	}
}
