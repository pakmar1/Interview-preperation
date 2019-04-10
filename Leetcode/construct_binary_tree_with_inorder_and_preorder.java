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
    private int preIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        return buildSubTree(preorder, inorder, 0, inorder.length-1, new TreeNode(0));
    }
    
	//numbers between left and right is the range of subtree
	//inorder[i] is a node in the subtree
    public TreeNode buildSubTree(int[] preorder, int[] inorder, int left, int right, TreeNode root) {
        if(left > right) return null;
        int rootVal = preorder[preIndex++];
        root.val = rootVal;
        int rootIndex = 0;
        for(int i = left; i <= right; i++) {
            if(inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }
        //left subtree
        root.left = buildSubTree(preorder, inorder, left, rootIndex-1, new TreeNode(0));
        //right subtree
        root.right = buildSubTree(preorder, inorder, rootIndex+1, right, new TreeNode(0));
        
        return root;
    }
}
