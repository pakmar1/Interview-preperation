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
    private int sum = 0;
    
    public int sumNumbers(TreeNode root) {
        if(root==null) return sum;
        traverse(root,"");
        return sum;
    }
    
    private void traverse(TreeNode root, String s) {
        s += root.val;
        if(root.left == null && root.right == null) {
            sum +=Integer.parseInt(s);
        }
        
        if(root.left!=null) {
            traverse(root.left,s);
        }
        if(root.right!=null) {
            traverse(root.right,s);
        }
    }
}
