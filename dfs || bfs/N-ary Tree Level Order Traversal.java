/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        // queue with delimter!
        // same idea as LC 994.Rotting Oranges and LC
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Node> q = new LinkedList<>();
        q.add(null);
        q.add(root);
        
        while(!q.isEmpty()) {
            Node curr = q.poll();
            if (curr == null) {
                if (q.isEmpty()) break;
                res.add(new ArrayList<>());
                q.add(null);
            } else {
                res.get(res.size() - 1).add(curr.val);
                for (Node node: curr.children) {
                    q.add(node);
                }
            }
        }
        
        return res;
    }
}
