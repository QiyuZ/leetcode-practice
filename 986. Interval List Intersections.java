class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i = 0, j = 0;
        List<int[]> res = new ArrayList<>();
        while (i < A.length && j < B.length) {
            int[] a = A[i], b = B[j];
            int start = Math.max(a[0], b[0]);
            int end = Math.min(a[1], b[1]);
            if (start <= end) res.add(new int[] {start, end});
            if (a[1] == end) i++; //谁短谁往前走
            if (b[1] == end) j++;
        }
        return res.toArray(new int[res.size()][2]);
    }
}
