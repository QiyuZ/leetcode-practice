class Solution {
    public int maxResult(int[] nums, int k) {
        if (nums == null || k <= 0) return 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[1] - a[1])); //here we need to sort by score to ensure we can get max score
        int max = nums[0];
        pq.offer(new int[] {0, max});
        for (int i = 1; i < nums.length; i++) {
            while (pq.peek()[0] + k < i) pq.poll(); //be careful that here we sort by score, so we need to use while not if
            max = nums[i] + pq.peek()[1];
            pq.offer(new int[] {i, max});
        }
        return max;
    }
}
