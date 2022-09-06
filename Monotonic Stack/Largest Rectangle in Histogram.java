class Solution {
    // monotonic increasing stack
    // 
    // 1. push -1 to initialize the stack
    // (for calculating the length, we don't have to do this step)
    // 
    // 2. keeping adding position if the value of heights is increasing
    // 
    // 3. if we find a value that is smaller than the top value of
    // the stack, we calculate the current maximum area based on
    // values in the stack that are larger than the current value
    
    // other good monotic stack questions
    // 2104. Sum of Subarray Ranges
    // 907. Sum of Subarray Minimums
    
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> increStack = new Stack<>();
        increStack.push(-1);
        int maxArea = 0;
        
        for (int i = 0; i < heights.length; i++) {
            while (increStack.peek() != -1 &&
                   heights[increStack.peek()] >= heights[i]) {
                int curHeight = heights[increStack.pop()];
                int curLength = i - increStack.peek() - 1;
                int curArea = curHeight * curLength;
                maxArea = Math.max(maxArea, curArea);
            }
            
            increStack.add(i);
        }
        
        // if the last element in the stack is greater, it won't
        // be processed in previous for loop
        while (increStack.peek() != -1) {
            int curHeight = heights[increStack.pop()];
            int curLength = heights.length - increStack.peek() - 1;
            int curArea = curHeight * curLength;
            maxArea = Math.max(maxArea, curArea);
        }
        
        return maxArea;
    }
}
