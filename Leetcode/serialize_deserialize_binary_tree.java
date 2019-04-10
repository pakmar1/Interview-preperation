// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        
        if(root == null) {
            return "";
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        sb.append(String.valueOf(root.val));
        sb.append(",");
        while(!q.isEmpty()) {
            int size = q.size();
            TreeNode cur = q.poll();
            
            if(cur.left != null) {
                sb.append(String.valueOf(cur.left.val));
                q.offer(cur.left);
            } else {
                sb.append("#");
                
            }
            sb.append(",");
            
             if(cur.right != null) {
                sb.append(String.valueOf(cur.right.val));
                 q.offer(cur.right);
            } else {
                sb.append("#");
            }
            sb.append(",");
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.equals("")) {
            return null;
        }
        
        String[] vals = data.split(",");
        
        TreeNode root = new TreeNode(Integer.valueOf(vals[0]));
        ArrayList<TreeNode> q = new ArrayList<>();
        q.add(root);
        int index = 0;
        boolean isLeft = true;
        for(int i = 1; i < vals.length; i++) {
            if(!vals[i].equals("#")) {
                TreeNode node = new TreeNode(Integer.parseInt(vals[i]));
                if(isLeft) {
                    q.get(index).left = node;
                } else {
                    q.get(index).right = node;
                }
                q.add(node);
            }
            if(!isLeft) {
                index++;
            }
            isLeft = !isLeft;
        }
        return root;
                                     
    }
