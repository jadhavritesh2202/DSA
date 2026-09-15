/* Binary Tree Node Structure
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
}
*/
class Solution {
    public int getCount(Node root, int k) {
        // code here
        Queue<Node> q=new LinkedList<>();
        ArrayList<Integer> list=new ArrayList<>();
        q.add(root);
        int level=0;
        
        while(!q.isEmpty()){
            level++;
            int size=q.size();
            while(size-->0){
                Node node=q.remove();
                if(node.left==null && node.right==null){
                    list.add(level);
                }
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
                
                
            }
        }
        int cnt=0;
        int sum=0;
      Collections.sort(list); 
        for(int num:list){
              sum+=num;
             if(sum<=k){
                 cnt++;
             }
        }
        return cnt;
        
        
    }
}