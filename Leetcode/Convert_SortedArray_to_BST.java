class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        TreeNode head = createBST(nums, 0, nums.length - 1);
        return head;
    }

    public TreeNode createBST(int[] num, int low, int high) {
        if (low > high) { // Done
        return null;
    }
        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = createBST(num, low, mid - 1);
        node.right = createBST(num, mid + 1, high);
        return node;
    }
}
