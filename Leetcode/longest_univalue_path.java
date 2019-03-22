/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    private  int maxVal=0;
    public int longestUnivaluePath(TreeNode root) {
        if(root ==null)
            return 0;
        this.helper(root,root.val);
        return  this.maxVal;
    }
    private int helper(TreeNode node, int prevVal){
        if (node ==null){
            return  0;
        }
        int left=this.helper(node.left,node.val);
        int right=this.helper(node.right,node.val);
        this.maxVal=Math.max(this.maxVal, left+right);
        if (node.val==prevVal){
            return Math.max(left,right)+1;
        }
        return  0;
    }
}
