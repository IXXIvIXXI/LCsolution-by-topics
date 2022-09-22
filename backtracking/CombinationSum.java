// LC 39
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        getSum(candidates, target, 0, new ArrayList<>());
        return res;
    }
    
    private void getSum(int[] candidates, int total, int start, List<Integer> solution) {
        if (total == 0) {
            
            List<Integer> ans = new ArrayList<>(solution);
            res.add(ans);
            
            return;
        }
        
        if (total < 0) return;
        
        for (int i = start; i < candidates.length; i++) {
            solution.add(candidates[i]);
            getSum(candidates, total - candidates[i], i, solution);
            solution.remove(solution.size() - 1);
        }
    }
}
