// LC 134
class Solution {
    // total sum should >= 0 if the loop can be finished
    // the start position must be reachable where gas - cost >= 0
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curTank = 0, totalTank = 0, start = 0;
        
        for (int i = 0; i < gas.length; i++) {
            curTank += gas[i] - cost[i];
            totalTank += gas[i] - cost[i];
            
            if (curTank < 0) {
                start = i + 1;
                curTank = 0;
            }
        }
        
        return totalTank < 0 ? -1 : start;
    }
}
