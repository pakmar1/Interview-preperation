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
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null) return new ArrayList<Integer>();
        
        List<Integer> list = new ArrayList<>();
        list = inorderRec(root,list);
        
        return list;
    }
    
    public List<Integer> inorderRec(TreeNode root, List<Integer> list) {
        if(root==null) return null;
        
        
        inorderRec(root.left,list);
        list.add(root.val);
        inorderRec(root.right,list);    
        
        
        return list;
    }
}
