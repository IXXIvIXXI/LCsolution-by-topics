// LC 264
class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        HashSet<Long> seen = new HashSet<>();
        long cur = 1;
        minHeap.add(cur);
        int[] primes = new int[]{2, 3, 5};
        
        while (n != 0) {
            cur = minHeap.poll();
            for (int i = 0; i < primes.length; i++) {
                if (seen.add(cur * primes[i])) {
                    minHeap.add(cur * primes[i]);
                }
            }
            n--;
        }
        return (int) cur;
    }
}
