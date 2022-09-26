class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(candidates, target, new ArrayList<>(), 0);
        return res;
    }
    
    private void backtracking(int[] candidates, int target, List<Integer> solution, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(solution));
            return;
        }
        
        if (target < 0) return;
        
        for (int i = start; i < candidates.length; i++) {
            if (i == start || candidates[i] != candidates[i - 1]) {
                solution.add(candidates[i]);
                backtracking(candidates, target - candidates[i], solution, i + 1);
                solution.remove(solution.size() - 1);    
            }
        }
    }
}
