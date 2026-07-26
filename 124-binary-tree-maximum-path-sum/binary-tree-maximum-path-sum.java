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
class Solution {
    int maxSum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathSum1(root);
        return maxSum;
    }
    public int maxPathSum1(TreeNode root){
         if(root==null) return 0;
         int left=Math.max(0,maxPathSum1(root.left));
         int right=Math.max(0,maxPathSum1(root.right));
         int currSum=left+root.val+right;
         maxSum=Math.max(maxSum,currSum);
         return root.val+Math.max(left,right);
    }

}