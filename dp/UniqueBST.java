class Solution {
    // G(n): the number of unique BST for a sequence of length n
    // F(i, n): the number of unique BST
    // F(n) = G(i -1) * G(n - i)
    // G(n) = /sigma^n_(i=1) F(i, n)
    public int numTrees(int n) {
        int[] unique = new int[n + 1];
        unique[0] = 1;
        unique[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                unique[i] += unique[j - 1] * unique[i - j];
            }
        }
        
        return unique[n];
    }
}
