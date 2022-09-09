class Solution {
    public void rotate(int[] nums, int k) {
        // 1, 2, 3, 4, 5, 6, 7
        // 7, 6, 5, 4, 3, 2, 1 (reversed)
        // 7, 6, 5 (first 3 elements) 4, 3, 2, 1
        // reverse first 3 elements and last 4 elements
        // 5, 6, 7, 1, 2, 3, 4
        
        // if k is greater than length
        // we only need  to rotate k % nums.length spots
        k = k % nums.length;
        
        reverse(0, nums.length - 1, nums);
        reverse(0, k - 1, nums);
        reverse(k, nums.length - 1, nums);
    }
    
    public void reverse(int start, int end, int[] nums) {
        int left = start, right = end;
        while (left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }
}
