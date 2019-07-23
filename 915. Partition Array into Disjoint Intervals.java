class Solution {
    public int partitionDisjoint(int[] A) {
        int max = A[0], curMax = A[0], pos = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] < curMax) {
                curMax = max;
                pos = i;
            } else if (A[i] > max) {
                max = A[i];
            }
        }
        return pos + 1;
    }
}
