class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) return new int[0];
        Deque<Integer> queue = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!queue.isEmpty() && queue.peek() < i - k + 1) queue.poll(); //前面的是最先加进来的，如果超过则poll出
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) queue.pollLast(); //新加进来的是可能的最大值，比较poll出比其小的
            queue.offer(i);
            if (i >= k - 1) res[pos++] = nums[queue.peek()];
        }
        return res;
    }
}
