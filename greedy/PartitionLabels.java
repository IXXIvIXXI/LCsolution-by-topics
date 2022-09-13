// LC 763
class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int[] lastIndex = new int[26];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            lastIndex[c - 'a'] = i;
        }
        
        int start = 0;
        int end = 0;
        
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            // if the last index of current character is larger
            // then current end, we update the boundary
            end = Math.max(end, lastIndex[c - 'a']);
            // we update res when we get to the boundary
            if (end == i) {
                res.add(end - start + 1);
                start = end + 1;
            }
        }
        
        return res;
    }
}
