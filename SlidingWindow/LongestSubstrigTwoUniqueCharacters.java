class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int max = 0, left = 0, right = 0;
        Set<Character> set = new HashSet<>();
        HashMap<Character, Integer> map = new HashMap<>();
        
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            set.add(rightChar);
            while (set.size() > 2) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    set.remove(leftChar);
                }
                left++;
            }
            map.putIfAbsent(rightChar, 0);
            map.put(rightChar, map.get(rightChar) + 1);
            max = Math.max(max, right - left + 1);
            right++;
        }
        
        return max;
    }
}
