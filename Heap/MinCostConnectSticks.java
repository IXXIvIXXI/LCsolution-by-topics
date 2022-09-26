class Solution {
    // minHeap problem
    public int connectSticks(int[] sticks) {
        int res = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int stick : sticks) {
            pq.add(stick);
        }
        
        int cur = 0;
        while (pq.size() > 1) {
            cur = pq.poll() + pq.poll();
            System.out.println(cur);
            res += cur;
            pq.add(cur);
        }
        
        return res;
    }
}
