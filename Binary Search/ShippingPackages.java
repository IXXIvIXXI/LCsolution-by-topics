// LC 1011
class Solution {
    // lower bound: the largest weight among all weights
    // upper bound: the sum of all weights, finish shipping in one day
    public int shipWithinDays(int[] weights, int days) {
        int low = 0, high = 0;
        int res = Integer.MAX_VALUE;
        
        for (int weight : weights) {
            high += weight;
            low = Math.max(low, weight);
        }
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isGoodSize(weights, mid, days)) {
                high = mid - 1;
                res = Math.min(res, mid);
            } else {
                low = mid + 1;
            }
        }
        
        return res;
    }
    
    private boolean isGoodSize(int[] weights, int size, int days) {
        int time = 1;
        int curTruck = 0;
        
        for (int weight : weights) {
            if (weight > size) return false;
            if (curTruck + weight > size) {
                curTruck = weight;
                time++;
            } else {
                curTruck += weight;
            }
        }
        
        return time <= days;
    }
}
