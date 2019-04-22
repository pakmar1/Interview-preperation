/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode node, StringBuilder sb) {
        if(node == null) return;

        sb.append(node.val).append(",");
        serializeHelper(node.left, sb);
        serializeHelper(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.isEmpty()) return null;
        String[] input = data.split(",");
        Queue<String> queue = new LinkedList<>();
        
        for(String str: input){
            queue.add(str);
        }
        TreeNode root = deserializeHelper(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return root;
    }

    private TreeNode deserializeHelper(Queue<String> queue, int min, int max) {
        if(queue.isEmpty()) return null;

        int val = Integer.valueOf(queue.peek());
        if(val < min || val > max) return null;

        queue.remove();
        TreeNode node = new TreeNode(val);
        node.left = deserializeHelper(queue, min, val);
        node.right = deserializeHelper(queue, val, max);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
