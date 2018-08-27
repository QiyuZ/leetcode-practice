class Solution {
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(K, new Comparator<int[]>() { //容量为K个即可
           public int compare(int[] o1, int[] o2) {
               return A[o1[0]] * A[o2[1]] - A[o1[1]] * A[o2[0]]; //min排列
           } 
        });
        int n = A.length;
        for (int i = 0; i < n; i++)  {
            if (K == i) break; //因为是从0开始，所以到K 停止
            queue.offer(new int[] {i, n - 1}); //放入index
        }
        while (!queue.isEmpty() && --K > 0) { //相当于找到第1个，所以做K-1次运算
            int[] cur = queue.poll();
            if (--cur[1] > cur[0]) queue.offer(cur); //因为分母可能是前一位的，放入可能结果
        }
        return new int[] {A[queue.peek()[0]], A[queue.peek()[1]]};
    }
}
