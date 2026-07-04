/*
Definition for Node
class Node {
	int data;
	Node left;
	Node right;
	
	Node(int val) {
		data = val;
		left = right = null;
	}
}
*/
class Pair {
	Node node;
	int path;
	Pair(Node node, int path) {
		this.node = node;
		this.path = path;
	}
}
class Solution {
	public ArrayList<ArrayList<Integer>> verticalOrder(Node root) {
		// code here
		if (root == null)
                 return new ArrayList<>();
		TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
		Queue<Pair> q = new LinkedList<>();
		
		q.add(new Pair(root, 0));
		
		while (!q.isEmpty()) {
			Pair pair = q.remove();
			Node val = pair.node;
			int dist = pair.path;
			map.putIfAbsent(dist, new ArrayList<>());
			map.get(dist).add(val.data);
			
			if (val.left != null)
				q.add(new Pair(val.left, dist - 1));
			
			if (val.right != null)
				q.add(new Pair(val.right, dist + 1));
			
		}
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		for (ArrayList<Integer> list:map.values()) {
			res.add(list);
		}
		return res;
		
	}
}
