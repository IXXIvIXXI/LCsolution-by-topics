// LC 2007
class Solution {
    // sort + HashMap
    // HashMap stores the frequency of each number
    public int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 == 1) return new int[0];
        Arrays.sort(changed);
        HashMap<Integer, Integer> freq = new HashMap<>();
        
        for (int num : changed) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        int[] res = new int[changed.length / 2];
        int i = 0;
        for (int num : changed) {
            if (freq.get(num) > 0) {
                freq.put(num, freq.get(num) - 1);
                int doubled = 2 * num;
                if (freq.containsKey(doubled) && freq.get(doubled) > 0) {
                    res[i++] = num;
                    freq.put(doubled, freq.get(doubled) - 1);
                } else {
                    // if map does not contain the doubled value or the amount of doubled value
                    // left is not enough to match the halved value
                    return new int[0];    
                }
            }
        }
        
        return res;
    }
}
