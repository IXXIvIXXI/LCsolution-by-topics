// LC 767
class Solution {
    public String reorganizeString(String s) {
        HashMap<Character, Integer> countMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) ->
                                                          countMap.get(b) - countMap.get(a));
        pq.addAll(countMap.keySet());
        
        StringBuilder res = new StringBuilder();
        while (pq.size() > 1) {
            char cur = pq.remove();
            char next = pq.remove();
            res.append(cur);
            res.append(next);
            countMap.put(cur, countMap.get(cur) - 1);
            countMap.put(next, countMap.get(next) - 1);
            if (countMap.get(cur) >= 1) {
                pq.add(cur);
            }
            if (countMap.get(next) >= 1) {
                pq.add(next);
            }
        }
        
        if (!pq.isEmpty()) {
            char last = pq.peek();
            if (countMap.get(last) != 1) {
                return "";
            }
            res.append(last);
        }
        return res.toString();
    }
}
