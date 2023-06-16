class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int i = 0;
        int res = 0;
        for (int d = 1; d <= 100000; d++) {
            while (i < events.length && events[i][0] == d) {
                minHeap.offer(events[i++][1]);
            }

            while (!minHeap.isEmpty() && minHeap.peek() < d) {
                minHeap.poll();
            }

            if (!minHeap.isEmpty()) {
                minHeap.poll();
                res++;
            }
        }

        return res;
    }
}
