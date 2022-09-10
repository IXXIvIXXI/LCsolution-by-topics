// super slow two pointers I came up with
class Solution {
    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int start = i;
                for (int j = i; j < nums.length - 1; j++) {
                    if (nums[j + 1] != 0) {
                        int tmp = nums[j + 1];
                        nums[j + 1] = nums[start];
                        nums[start] = tmp;
                        start = j + 1;
                    }
                }
            }
        }
    }
}

// optimized two pointers
class Solution {
    public void moveZeroes(int[] nums) {
        // when we see the non zero we move to beginning
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[left];
                nums[left] = tmp;
                left++;
            }
        }
    }
}

// a creative deque solution I came up with
class Solution {
    public void moveZeroes(int[] nums) {
        Deque<Integer> dq = new LinkedList<>();
        int zeros = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                dq.addLast(nums[i]);
                zeros++;
            }
            else dq.addFirst(nums[i]);
        }
        
        int last = nums.length - 1 - zeros;
        for (int i = 0; i < nums.length; i++) {
            int cur = dq.poll();
            if (cur == 0) nums[i] = 0;
            else {
                nums[last] = cur;
                last--;
            }
        }
    }
}
