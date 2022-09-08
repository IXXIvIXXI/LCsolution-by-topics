class HitCounter {
    Queue<Integer> hits;
    public HitCounter() {
        hits = new LinkedList<>();
    }
    
    public void hit(int timestamp) {
        hits.add(timestamp);
    }
    
    public int getHits(int timestamp) {
        
        while (!hits.isEmpty()) {
            int diff = timestamp - hits.peek();
            // you may assume that calls are being made to the system in chronological order
            // which means we can remove old values if it is out of range
            // otherwise everything left is in the range
            
            // since this is queue when we peek, we peek very first value we add to the queue
            if (diff >= 300) hits.remove();
            else break;
        }
        
        return hits.size();
    }
}
