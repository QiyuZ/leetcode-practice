class Solution {
    // public int repeatedNTimes(int[] A) {
    //     Arrays.sort(A);
    //     for (int i = 1; i < A.length; i++) {
    //         if (A[i] == A[i - 1]) return A[i];
    //     }
    //     return -1;
    // }
    
    public int repeatedNTimes(int[] A) {
        int[] set = new int[10001];
        for (int i = 0; i < A.length; i++) {
            if (set[A[i]] != 0) return A[i];
            set[A[i]]++;
        }
        return -1;
    }
}
