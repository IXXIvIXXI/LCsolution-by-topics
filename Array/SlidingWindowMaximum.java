class Solution {
    // monotonic queue problem
    // we need a decreasing queue
    // Time Complexity O(n)
    // Space Complexity O(n)
    
    // example: [8, 7, 6, 9], k=2
    
    // dq 8, 7    output 8        window: left = 0, right = 1
    // dq 7, 6    output 8 7      window: left = 1, right = 2
    // dq 9       output 8 7 9    window: left = 2, right = 3
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        // since window size is k, there are nums.length - k + 1 windows in total
        int[] windows = new int[nums.length - k + 1];
        int i = 0;
        Deque<Integer> dq = new LinkedList<>();
        int left = 0, right = 0;
        while (right < nums.length) {
            // if the number at the last index in dq is smaller than rightmost number
            // of current window, we remove it from our dq
            while(!dq.isEmpty() && nums[dq.getLast()] < nums[right]) {
                dq.removeLast();
            }
            
            // add index of right number to our dq
            dq.addLast(right);
            
            // check if the first index in dq is in the current window or not
            if (left > dq.peekFirst()) dq.removeFirst();
            
            // add largest number to the result array and move to the next window
            // if there are k element in the current window
            if (right + 1 >= k) {
                windows[i] = nums[dq.getFirst()];
                left++;
                i++;
            }
            
            right++;
        }
        return windows;
    }
}
