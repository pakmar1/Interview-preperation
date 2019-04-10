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
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root==null) return new ArrayList<Integer>();
        List<Integer> list = new ArrayList<>();
        list = preorderRec(root,list);
        return list;
    }
    
    public List<Integer> preorderRec(TreeNode root, List<Integer> list) {
        if(root==null) return null;
        list.add(root.val);
        preorderRec(root.left,list);
        preorderRec(root.right,list);    
        return list;
    }
    
}
