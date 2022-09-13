// LC 739
class Solution {
    // monotonic stack stores index instead of value
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> decreStack = new Stack<>();
        int size = temperatures.length;
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            while (!decreStack.isEmpty() && temperatures[decreStack.peek()] < temperatures[i]) {
                int pos = decreStack.pop();
                res[pos] = i - pos;
            }
            
            decreStack.push(i);
        }
        
        return res;
    }
}
