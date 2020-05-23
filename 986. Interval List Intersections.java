class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> res = new ArrayList<>();
        int a = 0, b = 0;
        while (a < A.length && b < B.length) {//题目中说已经sorted了
            int[] curA = A[a], curB = B[b];
            int start = Math.max(curA[0], curB[0]);//找重合开头找大的结尾找小的
            int end = Math.min(curA[1], curB[1]);
            if (start <= end) res.add(new int[] {start, end});
            if (curA[1] == end) a++;//哪个在前面就移动哪个，所以可以看取谁的end
            else b++;
        }
        return res.toArray(new int[res.size()][2]);//list to array 要标注size大小
    }
}
