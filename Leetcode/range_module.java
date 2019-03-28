class RangeModule {
    
    class TreeNode {
        int start, end;
        TreeNode left, right;
        public TreeNode(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    
    TreeNode root;
    
    public RangeModule() {
    }
    
    public void addRange(int left, int right) {
        root = addRange(root, left, right);
    }
    
    public boolean queryRange(int left, int right) {
        return queryRange(root, left, right);
    }
    
    public void removeRange(int left, int right) {
        root = removeRange(root, left, right);
    }
    
    private TreeNode addRange(TreeNode root, int start, int end) {
        if (start >= end) return root;
        if (root == null) return new TreeNode(start, end);
        if (root.start >= end) {
            root.left = addRange(root.left, start, end);
        } else if (root.end <= start) {
            root.right = addRange(root.right, start, end);
        } else {
            root.left = addRange(root.left, start, root.start);
            root.right = addRange(root.right, root.end, end);
        }
        return root;
    }
    
    private boolean queryRange(TreeNode root, int start, int end) {
        if (start >= end) return true;
        if (root == null) return false;
        if (start >= root.end) return queryRange(root.right, start, end);
        if (end <= root.start) return queryRange(root.left, start, end);
        if (start >= root.start && end <= root.end) return true;
        return queryRange(root.left,  start, root.start) && queryRange(root.right, root.end, end);
    }
    
    private TreeNode removeRange(TreeNode root, int start, int end) {
        if (start >= end) return root;
        if (root == null) return root;
        if (root.end <= start) {
            root.right = removeRange(root.right, start, end);
        } else if (root.start >= end) {
            root.left = removeRange(root.left, start, end);
        } else {
            root.left = removeRange(root.left, start, root.start);
            root.right = removeRange(root.right, root.end, end);
            root.left = addRange(root.left, root.start, start);
            root.right = addRange(root.right, end, root.end);
            root = remove(root);
        }
        return root;
    }
    private TreeNode remove(TreeNode node) {
        if (node == null) return null;
        if (node.left == null) return node.right;
        TreeNode leftLargest = getLargest(node.left, node);
        leftLargest.left = node.left;
        leftLargest.right = node.right;
        return leftLargest;
    }
    private TreeNode getLargest(TreeNode node, TreeNode parent) {
        while (node.right != null) {
            parent = node;
            node = node.right;
        }
        if (node == parent.left) parent.left = node.left;
        if (node == parent.right) parent.right = node.left;
        node.left = null;
        return node;
    }
    
   
    
}


/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */
