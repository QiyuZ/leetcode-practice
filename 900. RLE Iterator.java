class RLEIterator {
    private int i;
    private int[] A;
    public RLEIterator(int[] A) {
        int i = 0;
        this.A = A;
    }
    
    public int next(int n) {
        if (i == A.length) return -1;
        if (A[i] > n) {
            A[i] -= n;
            return A[i + 1];
        } else if (A[i] == n) {
            i += 2;
            return A[i - 1];
        } else {
            i += 2;
            return next(n - A[i - 2]);
        }
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(A);
 * int param_1 = obj.next(n);
 */
