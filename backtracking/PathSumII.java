class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();
        backtracking(root, 0, targetSum, new ArrayList<>());
        return res;
    }
    
    private void backtracking(TreeNode root, int cur, int targetSum, List<Integer> solution) {
        if (root == null) return;
        
        solution.add(root.val);
        if (cur + root.val == targetSum && root.left == null && root.right == null) {
            List<Integer> ans = new ArrayList<>(solution);
            res.add(ans);
            return;
        }
        
        if (root.left != null) {
            backtracking(root.left, cur + root.val, targetSum, solution);
            solution.remove(solution.size() - 1);
        }
        
        if (root.right != null) {
            backtracking(root.right, cur + root.val, targetSum, solution);
            solution.remove(solution.size() - 1);
        }
    }
}
