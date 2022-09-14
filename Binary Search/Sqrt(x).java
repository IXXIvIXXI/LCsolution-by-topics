// LC 69
class Solution {
    // binary search
    public int mySqrt(int x) {
        if (x < 2) return x;
        return findNum(x);
    }
    
    private int findNum(int x) {
        int left = 2, right = x / 2;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // in case integer overflow
            long num = (long)mid * mid;
            if (num > x) {
                right = mid - 1;
            } else if (num < x) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        
        return right;
    }
}
