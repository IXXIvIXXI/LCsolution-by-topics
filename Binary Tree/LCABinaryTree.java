// LC 236
// Time Complexity: O(N)
// Space Complexity: O(N)
class Solution {
    TreeNode res;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findLCA(root, p, q);
        return res;
    }
    
    private boolean findLCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean left = findLCA(root.left, p, q);
        boolean right = findLCA(root.right, p, q);
        boolean curr = (root.val == p.val || root.val == q.val);
        
        if (left && right || left && curr || right && curr) res = root;
        
        return left || right || curr; 
    }
}
