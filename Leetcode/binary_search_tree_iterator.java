/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {
    static List<Integer> res = new ArrayList<>();

    public BSTIterator(TreeNode root) {
        BSTIterator(root);
    }

    private void BSTIterator(TreeNode root) {
        if (root == null)
            return;
        BSTIterator(root.left);
        res.add(root.val);
        BSTIterator(root.right);

    }

    /** @return the next smallest number */
    public int next() {
        int x = res.get(0);
        res.remove(0);
        return x;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !res.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
