class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        // apply level order traversal algorithm
        levelOrder(root, levels, 0);
        // get last element from each level
        for (List<Integer> level : levels) {
            res.add(level.get(level.size() - 1));
        }
        return res;
    }
    
   private void levelOrder(TreeNode root, List<List<Integer>> levels, int level) {
       if (root == null) return;
       if (levels.size() == level) levels.add(new ArrayList<>());
       levels.get(level).add(root.val);
       levelOrder(root.left, levels, level + 1);
       levelOrder(root.right, levels, level + 1);
   }
}

// optimized solution from above
class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return res;
        getRight(root, 0);
        return res;
    }
    
   private void getRight(TreeNode root, int level) {
       if (res.size() == level) res.add(root.val);
       if (root.right != null) getRight(root.right, level + 1);
       if (root.left != null) getRight(root.left, level + 1);
   }
}

// BFS
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
