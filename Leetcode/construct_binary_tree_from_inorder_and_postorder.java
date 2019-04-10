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
    int rootPointer;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
    
    private TreeNode buildTree(int[] inorder, int in_start, int in_end, int[] postorder, int post_start, int post_end) {
        if (in_start > in_end || post_start > post_end) return null;
        
        TreeNode root = new TreeNode(postorder[post_end]);
        int i;
        for (i=in_start; i<=in_end; i++)
            if (inorder[i] == root.val) break;
        
        root.left = buildTree(inorder, in_start, i-1, postorder, post_start, post_start+(i-in_start)-1);
        root.right = buildTree(inorder, i+1, in_end, postorder, post_end-(in_end-i), post_end-1);
        return root;
    }
}
