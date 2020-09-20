class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            if (A[i][0] > B[j][1]) j++;//这两行是找到重叠的
            else if (A[i][1] < B[j][0]) i++;
            else {
                int start = Math.max(A[i][0], B[j][0]);
                if (A[i][1] < B[j][1]) res.add(new int[] {start, A[i++][1]}); //哪个小哪个是end并且移动
                else res.add(new int[] {start, B[j++][1]});
            }
        }
        return res.toArray(new int[0][0]);
    }
}
