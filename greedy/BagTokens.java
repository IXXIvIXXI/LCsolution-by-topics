class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int res = 0, score = 0, left = 0, right = tokens.length - 1;
        
        while (left <= right) {
            if (power >= tokens[left]) {
                power -= tokens[left];
                left++;
                score++;
                res = Math.max(res, score);
            } else if (power < tokens[left] && score > 0) {
                score--;
                power += tokens[right];
                right--;
            } else {
                // if power < tokens[left] and no score to borrow more
                return res;
            }
        }
        
        return res;
    }
}
