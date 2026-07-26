/*
class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/

class Solution {
    public ArrayList<Node> findPreSuc(Node root, int key) {
        // code here
        ArrayList<Node> res=new ArrayList<>();
        ArrayList<Node> list=new ArrayList<>();
        inorder(root,list);
        
        Node left=null;
        Node right=null;
        for(Node ele:list){
            if(ele.data<key){
                left=ele;
            }else if(ele.data > key){
                right=ele;
                break;
            }
        }
        res.add(left);res.add(right);
        return res;
        
    }
    public void inorder(Node root,ArrayList<Node> list){
        if(root==null) return;
        inorder(root.left,list);
        list.add(root);
        inorder(root.right,list);
    }
}