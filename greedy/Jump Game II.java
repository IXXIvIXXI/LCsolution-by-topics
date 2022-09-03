class Solution {
    public int jump(int[] nums) {
        int res = 0;
        int farthest = 0, curJump = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (curJump == i) {
                curJump = farthest;
                res++;
            }
        }
        
        return res;
    }
}

class Solution {
    public int jump(int[] nums) {
        int res = 0;
        int left = 0, right = 0;
        while (right < nums.length - 1) {
            int farthest = 0;
            for (int i = left; i <= right; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            left = right + 1;
            right = farthest;
            res++;
        }
        
        return res;
    }
}
