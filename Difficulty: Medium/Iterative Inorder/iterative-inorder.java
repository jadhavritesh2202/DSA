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
};
*/
class Solution {
	public ArrayList<Integer> inOrder(Node root) {
		// code here
		ArrayList<Integer> list = new ArrayList<>();
		Node curr = root;
		
		while (curr != null) {
			// 1st case: if left is null, print current node and go right
			if (curr.left == null) {
				list.add(curr.data);
				curr = curr.right;
			} else {
				// 2nd case: before going left, make right most node on left subtree
				// connected to current node, then go left
				Node prev = curr.left;
				while (prev.right != null && prev.right != curr) {
					prev = prev.right;
				}
				
				if (prev.right == null) {
					prev.right = curr;
					curr = curr.left;
				} else {
					/*if curr's right most node on the left subtree is pointing to curr itself
					i)print curr
					ii)remove thread
					iii)move curr to right*/
					prev.right=null;
					list.add(curr.data);
					curr=curr.right;
				}
			}
		}
		return list;
	}
}
