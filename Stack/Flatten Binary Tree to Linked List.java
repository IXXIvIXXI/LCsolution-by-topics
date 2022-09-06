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
    /*
    public void flatten(TreeNode root) {
        // edge case check
        if (root == null) return;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        
        while (!s.isEmpty()) {
            // in each iteration, we add right subtree and
            // left subtree to the stack if they are not null.
            // make sure left subtree is always on the top of the
            // stack if it's possible
            TreeNode cur = s.pop();
            if (cur.right != null) s.push(cur.right);
            if (cur.left != null) s.push(cur.left);
            if (s.isEmpty()) continue;
            cur.right = s.peek();
            cur.left = null;
        }
    }
    */
    
    // a faster solution
    public void flatten(TreeNode root) {
        if (root == null) return;
        
        TreeNode curNode = root;
        
        // in each iteration, if our current Node has a left subtree
        // we create a reference for the left subtree and trying to find
        // the right-most node of left subtree. After we get the right-most
        // node, we connect the right subtree of current node to its right subtree.
        // Then we rewire the connection of current node and move to the right subtree
        while (curNode != null) {
            if (curNode.left != null) {
                TreeNode rightMost = curNode.left;
                while (rightMost.right != null) rightMost = rightMost.right;
                rightMost.right = curNode.right;
                curNode.right = curNode.left;
                curNode.left = null;
            }
            curNode = curNode.right;
        }
    }
}
