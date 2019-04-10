/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
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
    
    ********************** bottom-up approach: check children first, then come to parent ***********************
    public int maxDepth1(TreeNode root) {
        if(root==null){
            return 0;
        }
        int right_depth = maxDepth(root.right);
        int left_depth = maxDepth(root.left);
        
        return Math.max(left_depth, right_depth)+1;
    }
    
    
    ************************ top-bottom approach: check parent first, then head to children ***********************
    int answer;
    public int maxDepth(TreeNode root) {
        
        answer = 0;
        maximum_depth(root,1);
        return answer;
        
    }
    
    public void maximum_depth(TreeNode root, int depth) {
        if(root == null) {
            return;
        }
        
        if(root.left == null && root.right == null) {
            answer = Math.max(answer,depth);
        }
        
        maximum_depth(root.left,depth+1);
        maximum_depth(root.right,depth+1);
        
        
    }
    
    
}
