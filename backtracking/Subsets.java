class Solution {
    // backtracking
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for (int size = 0; size <= nums.length; size++) {
            backtracking(size, nums, 0, res, new ArrayList<>());
        }
        return res;
    }
    
    private void backtracking(int size, int[] nums, int start,
                              List<List<Integer>> res, List<Integer> curList) {
        if (size == 0) {
            res.add(new ArrayList(curList));
            return;
        }
        
        for (int i = start; i < nums.length; i++) {
            // choose
            curList.add(nums[i]);
            // explore, start will be i + 1 to avoid choosing value in the same bucket
            // of the array
            backtracking(size - 1, nums, i + 1, res, curList);
            // unchoose
            curList.remove(curList.size() - 1);
        }
    }
}
