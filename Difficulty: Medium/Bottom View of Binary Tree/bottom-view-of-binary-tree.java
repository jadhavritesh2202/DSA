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
	int dist;
	Pair(Node node, int dist) {
		this.node = node;
		this.dist = dist;
	}
}
class Solution {
	public ArrayList<Integer> bottomView(Node root) {
		// code here
		ArrayList<Integer> list = new ArrayList<>();
		
		TreeMap<Integer, Integer> map = new TreeMap<>();
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(root, 0));
		
		while (!q.isEmpty()) {
			Pair p = q.remove();
			Node node = p.node;
			int dist = p.dist;
			map.put(dist, node.data);
			if (node.left != null) {
				q.add(new Pair(node.left, dist - 1));
			}
			if (node.right != null) {
				q.add(new Pair(node.right, dist + 1));
			}
		}
		list.addAll(map.values());
		return list;
	}
}
