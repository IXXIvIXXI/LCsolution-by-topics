/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // idea:
    //  compare values of two current nodes
    //  if they are same compare the right subtree
    //  of node 1 with the left subtree of node2
    //  and left subtree of node1 with right subtree
    //  of node2. return false otherwise
    
    // edge cases:
    //  both null? good
    //  one is null but the other one isn't? false
    public boolean isSymmetric(TreeNode root) {
        return symmetricChecker(root.left, root.right);
    }
    
    private boolean symmetricChecker(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;
        
        if (node1.val == node2.val) {
            return symmetricChecker(node1.right, node2.left) &&
                    symmetricChecker(node1.left, node2.right);
        }
        return false;
    }
}
