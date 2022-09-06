class Solution {
    /*
    public int singleNumber(int[] nums) {
        if set doesn't have the given element
        add to set. Otherwise remove it. At the
        end there is only one number in our set

        Set<Integer> s = new HashSet<>();
        
        for (int num : nums) {
            if (!s.add(num)) {
                s.remove(num);
            }
        }
        
        int res = 0;
        for (int num : s) res = num;
        return res;
    }
    */
    public int singleNumber(int[] nums) {
        // math: 2 * (a + b + c) - (a + a + b + b + c) = c
        Set<Integer> s = new HashSet<>();
        int totalSum = 0;
        int setSum = 0;
        
        for (int num : nums) {
            if (s.add(num)) {
                setSum += num;
            }
            totalSum += num;
        }
        
        return 2 * setSum - totalSum;
    }
}
