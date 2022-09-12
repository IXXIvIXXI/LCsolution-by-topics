class Solution {
    // prefix sum
    int res;
    int target;
    HashMap<Long, Integer> countMap;
    public int pathSum(TreeNode root, int targetSum) {
        res = 0;
        target = targetSum;
        countMap = new HashMap<>();
        findPath(root, 0L);
        return res;
    }
    
    private void findPath(TreeNode root, Long sum) {
        if (root == null) {
            return;
        }
        
        sum += root.val;
        if (sum == target) res++;
        
        // check if we have new path we need to update based
        // on sum - target
        res += countMap.getOrDefault(sum - target, 0);
        
        countMap.put(sum, countMap.getOrDefault(sum, 0) + 1);
        
        findPath(root.left, sum);
        findPath(root.right, sum);
        
        // remove current path from hashMap since we have explore,
        // we don't wanna count again
        countMap.put(sum, countMap.get(sum) - 1);
    }
}
