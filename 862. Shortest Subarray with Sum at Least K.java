class Solution {
    public int shortestSubarray(int[] A, int K) {
        int[] sum = new int[A.length + 1];
        for (int i = 1; i < sum.length; i++) sum[i] = sum[i - 1] + A[i - 1];
        int res = A.length + 1;
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < sum.length; i++) {
            while (!queue.isEmpty() && sum[i] - sum[queue.getFirst()] >= K) res = Math.min(res, i - queue.pollFirst());
            //算完就poll，因为无论接下来如何长度都会增加
            while (!queue.isEmpty() && sum[i] - sum[queue.getLast()] <= 0) queue.pollLast();
            //如果这一段的sum<=0那么就没有必要算了，因为这是后面的负担，长度增加，sum不加
            queue.addLast(i);
        }
        return res == A.length + 1 ? -1 : res;
    }
}
//正常n^2算法，算出sum然后一个个的找最小，其实有浪费，因为一段为负数后就没必要考虑这段
