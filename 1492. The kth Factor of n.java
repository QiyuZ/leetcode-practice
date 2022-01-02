class Solution {
    public int kthFactor(int n, int k) {//O(sqrt). we can actually use pq to offer i and n/i every time. To save space, we can iterate twice to first add i and then add n / i
        int root = (int)Math.sqrt(n);
        for (int i = 1; i <= root; i++) {
            if (n % i == 0) {
                k--;
                if (k == 0) return i;
            }
        }
        for (int i = root; i > 0; i--) {
            if (i * i == n) continue; //skip the root if it can be factor to avoid duplicate
            if (n % i == 0) {
                k--;
                if (k == 0) return n / i;
            }
        }
        return -1;
    }
}
