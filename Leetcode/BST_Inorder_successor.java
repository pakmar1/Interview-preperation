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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode answer = null, current = root;
        while (current != null) {
            if (current.val > p.val) {
                answer = current;
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return answer;
    }
}
