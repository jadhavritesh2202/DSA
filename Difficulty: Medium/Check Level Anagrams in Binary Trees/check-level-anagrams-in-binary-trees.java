/* Structure of binary tree Node
class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/

import java.util.*;

class Solution {
    public boolean areAnagrams(Node root1, Node root2) {

        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();

        q1.add(root1);
        q2.add(root2);

        while (!q1.isEmpty() && !q2.isEmpty()) {

            int size1 = q1.size();
            int size2 = q2.size();

            if (size1 != size2) {
                return false;
            }

            ArrayList<Integer> list1 = new ArrayList<>();
            ArrayList<Integer> list2 = new ArrayList<>();

            for (int i = 0; i < size1; i++) {

                Node n1 = q1.poll();
                Node n2 = q2.poll();

                list1.add(n1.data);
                list2.add(n2.data);

                if (n1.left != null) q1.add(n1.left);
                if (n1.right != null) q1.add(n1.right);

                if (n2.left != null) q2.add(n2.left);
                if (n2.right != null) q2.add(n2.right);
            }

            Collections.sort(list1);
            Collections.sort(list2);

            if (!list1.equals(list2)) {
                return false;
            }
        }

        return q1.isEmpty() && q2.isEmpty();
    }
}