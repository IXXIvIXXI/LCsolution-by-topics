class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> level = new LinkedList<>();
        level.add(root);
        
        
        while(!level.isEmpty()) {
            int size = level.size();
            for(int i = 0; i < size; i++) {
                TreeNode curNode = level.poll();
                if (i == size - 1) {
                    res.add(curNode.val);
                }
                
                if (curNode.left != null) level.add(curNode.left);
                if(curNode.right != null) level.add(curNode.right);
            }
        }
        
        return res;
    }
}
