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
    // mostly identical with 314.314. Binary Tree Vertical Order Traversal
    // we need to sort our data before adding them to the result
    // if same col and row, sort by value
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<DataNode> nodeList = new ArrayList<>();
        dfs(nodeList, root, 0, 0);
        Collections.sort(nodeList, new Comparator<DataNode>() {
            @Override
            public int compare(DataNode node1, DataNode node2) {
                if (node1.col == node2.col) {
                    if (node1.row == node2.row) {
                        return node1.val - node2.val;
                    } else {
                        return node1.row - node2.row;
                    }
                } else {
                    return node1.col - node2.col;
                }
            }
        });
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curColVals = new ArrayList<>();
        int curCol = nodeList.get(0).col;
        for (DataNode node : nodeList) {
            if (curCol == node.col) {
                curColVals.add(node.val);
            } else {
                res.add(curColVals);
                curCol = node.col;
                curColVals = new ArrayList<>();
                curColVals.add(node.val);
            }
        }
        res.add(curColVals);
        
        return res;
    }
    
    private void dfs(List<DataNode> nodeList, TreeNode root, int row, int col) {
        if (root == null) return;
        nodeList.add(new DataNode(row, col, root.val));
        dfs(nodeList, root.left, row + 1, col - 1);
        dfs(nodeList, root.right, row + 1, col + 1);
    }
}

class DataNode {
    int row;
    int col;
    int val;
    
    public DataNode(int row, int col, int val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }
}
