class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[] {};
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int[] leftMax = new int[n];
        leftMax[0] = nums[0];
        for (int i = 0; i < n; i++) {
            leftMax[i] = i % k == 0 ? nums[i] : Math.max(nums[i], leftMax[i - 1]);
        }
        int[] rightMax = new int[n];
        rightMax[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = i % k == 0 ? nums[i] : Math.max(nums[i], rightMax[i + 1]);
        }
        for (int i = 0; i < res.length; i++) {
            res[i] = Math.max(leftMax[i + k - 1], rightMax[i]);
        }
        return res;
    }
}

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) return new int[0];
        Deque<Integer> queue = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!queue.isEmpty() && queue.peek() + k - 1 < i) queue.poll(); //前面的是最先加进来的，如果超过则poll出
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) queue.pollLast(); //新加进来的是可能的最大值，比较poll出比其小的
            queue.offer(i);
            if (i >= k - 1) res[pos++] = nums[queue.peek()];
        }
        return res;
    }
}
