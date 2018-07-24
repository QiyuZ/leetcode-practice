class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        if (A == null || A.length == 0) return A;
        for (int[] row : A) {
            int n = row.length;
            for (int i = 0; i * 2 < n; i++) {
                if (row[i] == row[n - i - 1]) row[i] = row[n - i - 1] ^= 1;
                //相同的交换还相同，再取次反；不同的交换相当于取反，再反相当于没有变
            }
        }
        return A;
    }
}
