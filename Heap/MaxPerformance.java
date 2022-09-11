// LC 1383
class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int modulo = (int) Math.pow(10, 9) + 7;
        List<Pair<Integer, Integer>> engineers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            engineers.add(new Pair(efficiency[i], speed[i]));
        }
        // sort efficiency in descending order
        Collections.sort(engineers, (a, b) -> (b.getKey() - a.getKey()));
        
        PriorityQueue<Integer> speedHeap = new PriorityQueue<>((a, b) -> a - b);
        long totalSpeed = 0, maxPerform = 0;
        for (Pair<Integer, Integer> p : engineers) {
            Integer curEfficiency = p.getKey();
            Integer curSpeed = p.getValue();
            
            if (speedHeap.size() > k - 1) {
                totalSpeed -= speedHeap.remove();
            }
            
            totalSpeed += curSpeed;
            speedHeap.add(curSpeed);
            maxPerform = Math.max(maxPerform, totalSpeed * curEfficiency);
        }
        
        return (int) (maxPerform % modulo);
    }
}
