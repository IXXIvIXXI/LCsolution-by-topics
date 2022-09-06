class Solution {
    // back tracking problem
    // similar question: 78.subsets
    private List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        backtracking(new ArrayList<>(), 0, s);
        return res;
    }
    
    private void backtracking(List<String> solution, int start, String s) {
        // base case
        if (start == s.length()) {
            res.add(new ArrayList<>(solution));
            return;
        }
        
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(start, i, s)) {
                // choose
                solution.add(s.substring(start, i + 1));
                // explore, start from the next character after the current
                // palindromic substring
                backtracking(solution, i + 1, s);
                // unchoose
                solution.remove(solution.size() - 1);
            }   
        }
    }
    
    private boolean isPalindrome(int start, int end, String s) {
        int left = start;
        int right = end;
        
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        
        return true;
    }
}
