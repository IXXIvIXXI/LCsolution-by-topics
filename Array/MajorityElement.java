class Solution {
    public int majorityElement(int[] nums) {
        // Boyer-Moore Voting Algorithm
        int count = 0;
        Integer candidate = null;
        
        for (int num : nums) {
            if (count == 0) candidate = num;
            count += (candidate == num ? 1 : -1);
        }
        
        return candidate;
    }
}
