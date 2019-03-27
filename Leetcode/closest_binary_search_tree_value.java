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
    double min = Double.MAX_VALUE;
    TreeNode result;
    public int closestValue(TreeNode root, double target) {
        helper(root, target);
        return result.val;
    }
    
    public void helper(TreeNode root, double target) {
        if(root == null)
            return;
        
        if(Math.abs(root.val - target) < min) {
            min = Math.abs(root.val - target);
            result = root;
        }

        if(root.val > target)
            helper(root.left, target);
        else
            helper(root.right, target);
    }
    
}
