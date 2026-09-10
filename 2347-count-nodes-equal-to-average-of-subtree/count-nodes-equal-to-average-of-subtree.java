/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Pair{
    int sum;
    int cnt;
    Pair(int sum,int cnt){
        this.sum=sum;
        this.cnt=cnt;
    }
}
class Solution {
    int ans=0;
    public int averageOfSubtree(TreeNode root) {
          
          solve(root);
          return ans;
    }
    public Pair solve(TreeNode root){
        if(root==null){
            return new Pair(0,0);
        }
        //left subtree
        Pair left=solve(root.left);

        //right
        Pair right=solve(root.right);

        int sum=root.val+left.sum+right.sum;
        int cnt=1+left.cnt+right.cnt;
        if(root.val==sum/cnt){
            ans++;
        }
        return new Pair(sum,cnt);
    }
}