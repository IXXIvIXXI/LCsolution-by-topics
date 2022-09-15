class Solution {
    // 2^10 -> 2^5 * 2^5
    // 2^5 -> 2 * 2^2 * 2^2
    // 2^2 -> 2 * 2
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        
        return getPow(x, N);
    }
    
    private double getPow(double x, long n) {
        if (n == 0) return 1.0;
        double half = getPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}
