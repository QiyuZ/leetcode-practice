class Solution {
    public int largestSumAfterKNegations(int[] A, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int a : A) queue.offer(a);
        while (K-- > 0) queue.offer(queue.poll() * -1); 
        //难点就在于-1可能作用于最小的负数或者最小正数若干次，这里用优先队列每次都操作最小的，即使没负数了，变得正数依然是最小的
        int res = 0;
        while (!queue.isEmpty()) res += queue.poll(); 
        return res;
    }
}
