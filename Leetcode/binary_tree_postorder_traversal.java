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
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<Integer>();
        
        List<Integer> list = new ArrayList<>();
        list = postorderRec(root,list);
        
        return list;
        
    }
    
    public List<Integer> postorderRec(TreeNode root, List<Integer> list) {
        if(root == null) return null;
        
        postorderRec(root.left,list);
        postorderRec(root.right,list);
        list.add(root.val);
        
        return list;
    }
}
