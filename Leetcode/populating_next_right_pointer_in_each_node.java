/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        LinkedList<Node> queue = new LinkedList<>();
        if (root!=null)
            queue.offer(root);
        
        while (!queue.isEmpty()) {
            int siz = queue.size();
            for (int i=0; i<siz; i++) {
                Node n = queue.poll();
                n.next = i<siz-1? queue.peek(): null;                
                if (n.left!=null)
                    queue.offer(n.left);
                if (n.right!=null)
                    queue.offer(n.right);
            }
        }
        
        return root;
    }
}
