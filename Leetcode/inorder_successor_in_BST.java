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
    boolean trigger = false;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode answer = null;
        while (root != null) {
            if (root.val > p.val) {
                answer = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return answer;
    }
}
