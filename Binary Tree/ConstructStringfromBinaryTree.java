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
    public String tree2str(TreeNode root) {
        return findString(root);
    }

    // if right node is null, we skip the right part
    // case "left node is null" can be covered by
    // root.val + "(" + findString(root.left) + ")" + "(" + findString(root.right) + ")"
    // since we ret empty string for null
    private String findString(TreeNode root) {
        if (root == null) return "";
        else if (root.left == null && root.right == null) return "" + root.val;
        else if (root.right == null) return root.val + "(" + findString(root.left) + ")";
        return root.val + "(" + findString(root.left) + ")" + "(" + findString(root.right) + ")";
    }
}
