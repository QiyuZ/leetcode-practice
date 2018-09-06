class Solution {
    public boolean isMonotonic(int[] A) {
        int up = 0, down = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] == A[i - 1]) continue;
            else if (A[i] > A[i - 1]) up++;
            else down++;
        }
        return up == 0 || down == 0;
    }
}
