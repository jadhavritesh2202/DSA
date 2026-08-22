/* Definition for Node
class Node
{
    int data;
    Node left;
    Node right;
    Node(int val)
    {
        this.data = val;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public ArrayList<ArrayList<Integer>> paths(Node root) {
        // code here
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        ArrayList<Integer> list=new ArrayList<>();
        helper(root,ans,list);
        return ans;
        
    }
    public static void helper(Node root, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> list){
        if(root==null) return;
        list.add(root.data);
        if(root.left==null && root.right==null){
             ArrayList<Integer> subList=new ArrayList<>();
             subList.addAll(list);
             ans.add(subList);
        }
        helper(root.left,ans,list);
        helper(root.right,ans,list);
        list.remove(list.size()-1);
    }
}