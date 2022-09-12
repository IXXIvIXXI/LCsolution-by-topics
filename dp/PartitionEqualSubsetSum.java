class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        
        if (total % 2 != 0) return false;
        int subsetSum = total / 2;
        int len = nums.length;
        Boolean[][] memo = new Boolean[len][subsetSum + 1];
        return dfs(nums, len - 1, subsetSum, memo);
    }
    
    private boolean dfs(int[] nums, int n, int sum, Boolean[][] memo) {
        if (sum == 0) return true;
        if (n == 0 || sum < 0) return false;
        // check the result of given n and sum has been computed or not
        if (memo[n][sum] != null) return memo[n][sum];
        boolean res = dfs(nums, n - 1, sum - nums[n - 1], memo) ||
                dfs(nums, n - 1, sum, memo);
        // cache result
        memo[n][sum] = res;
        return res;
    }
}
