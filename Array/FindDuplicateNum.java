class Solution {
    public int findDuplicate(int[] nums) {
        // Floyd's Tortoise and Hare
        // find intersection and one start from the intersection point
        // and the other one starts from the beginning. They will
        // meet up at the same point and that's the duplicate
        
        int tortoise = nums[0];
        int hare = nums[0];
        
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);
        
        tortoise = nums[0];
        
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }
        
        return hare;
    }
}

class Solution {
    public int findDuplicate(int[] nums) {
        // binary search
        // we choose a value if the number of samller or equal values
        // in the array is greater than the choosing value
        // we need to decrease the range
        // 1, 2, 3, 4, 4, choosing value: 4, number of smaller or equal values: 5
        // which means the depulicate is a value smaller than ot equal to 4
        int low = 1;
        int hi = nums.length - 1;
        int dup = -1;
        
        while (low <= hi) {
            int mid = low + (hi - low) / 2;
            
            int count = 0;
            for (int num : nums) {
                if (num <= mid) count++;
            }
            
            if (count > mid) {
                dup = mid;
                hi = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return dup;
    }
}
