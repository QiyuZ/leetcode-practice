class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int[] markA = new int[7], markB = new int[7];
        int n = A.length;
        for (int i = 0; i < n; i++) {
            markA[A[i]]++;
            markB[B[i]]++;
        }
        for (int i = 1; i <= 6; i++) {
            if (markA[i] == n || markB[i] == n) return 0;
            if (markA[i] + markB[i] >= n) return getCount(i, A, B); 
            //只会有一个或者两个结果，因为长度是2n,而如果有两个则答案是相同的,都成立或者都不成立
        }
        return -1;
    }
    
    private int getCount(int target, int[] A, int[] B) {
        int n = A.length, countA = 0, countB = 0, swapA = 0, swapB = 0;
        for (int i = 0; i < n; i++) {
            if (target == A[i] && target != B[i]) swapB++;
            else if (target != A[i] && target == B[i]) swapA++;
            if (target == A[i]) countA++;
            if (target == B[i]) countB++;
        }
        if (countA + swapA == n && countB + swapB == n) return Math.min(swapA, swapB);
        if (countA + swapA == n) return swapA;
        if (countB + swapB == n) return swapB;
        return -1;
        
    }
}
