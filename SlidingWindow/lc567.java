class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] feq1 = new int[26];
        int[] feq2 = new int[26];
        int windowSize = s1.length();

        for (int i = 0; i < s1.length(); i++) {
            feq1[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s2.length(); i++) {
            feq2[s2.charAt(i) - 'a']++;

            if (i >= windowSize) {
                feq2[s2.charAt(i - windowSize) - 'a']--;
            }

            if (Arrays.equals(feq1, feq2)) {
                return true;
            }
        }

        return false;
    }
}
