class Solution {
    // sorting
    public int numberOfWeakCharacters(int[][] properties) {
        int res = 0;
        int maxD = 0;
        // if two props have same atk we sort def in a descending way so that we won't overcount
        Arrays.sort(properties, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        
        for (int i = properties.length - 1; i >= 0; i--) {
            if (properties[i][1] < maxD) {
                res++;
            }
            maxD = Math.max(maxD, properties[i][1]);
        }
        
        return res;
    }
}

class Solution {
    // sorting
    public int numberOfWeakCharacters(int[][] properties) {
        // since 1 <= attacki, defensei <= 10^5
        int[] maxD = new int[100002];
        int res = 0;
        
        for (int[] prop : properties) {
            int atk = prop[0];
            int def = prop[1];
            maxD[atk] = Math.max(maxD[atk], def);
        }
        
        for (int i = maxD.length - 2; i >= 1; i--) {
            // update the largest def we can have up to atk with value i
            maxD[i] = Math.max(maxD[i], maxD[i + 1]);
        }
        
        for (int[] prop : properties) {
            int atk = prop[0];
            int def = prop[1];
            // if maxD[atk + 1] has a def value greater than def of current prop
            // it means there is at least one pair in the array with greater atk
            // and def than the current pair
            if (def < maxD[atk + 1]) res++;
        }
        
        return res;
    }
}
