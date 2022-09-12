class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        if (sLen < pLen) return new ArrayList<>();
        
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> pMap = new HashMap<>();
        
        for (char c : p.toCharArray()) {
            pMap.putIfAbsent(c, 0);
            pMap.put(c, pMap.get(c) + 1);
        }
        
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < sLen; i++) {
            char cur = s.charAt(i);
            sMap.putIfAbsent(cur, 0);
            sMap.put(cur, sMap.get(cur) + 1);
            
            // remove or decrement the character not include in the
            // window
            if (i >= pLen) {
                char leftMostC = s.charAt(i - pLen);
                if (sMap.get(leftMostC) == 1) {
                    sMap.remove(leftMostC);
                } else {
                    sMap.put(leftMostC, sMap.get(leftMostC) - 1);
                }
            }
            
            if (pMap.equals(sMap)) {
                res.add(i - pLen + 1);
            }
        }
        
        return res;
    }
}
