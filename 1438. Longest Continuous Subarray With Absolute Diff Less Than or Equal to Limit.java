class Solution {
    public int longestSubarray(int[] nums, int limit) {
        if (nums == null || nums.length == 0) return 0;
        Deque<Integer> maxQueue = new LinkedList<>(), minQueue = new LinkedList<>(); //record max and min value in the window, we need the queue otherwise when we remove the max or min, we don't know the next one
        int res = 1, l = 0, r = 0, n = nums.length;
        for (; r < n; r++) {
            while (!maxQueue.isEmpty() && maxQueue.peekLast() < nums[r]) maxQueue.pollLast(); //add and compare from end to start, then the peek first one is max/min one
            maxQueue.offerLast(nums[r]); //as we use l, r, we can record val rather than index here
            while (!minQueue.isEmpty() && minQueue.peekLast() > nums[r]) minQueue.pollLast(); //note, here we poll last
            minQueue.offerLast(nums[r]);
            while (maxQueue.peekFirst() - minQueue.peekFirst() > limit) { //when invalid, move left till valid
                if (nums[l] == maxQueue.peekFirst()) maxQueue.pollFirst(); //here we poll first
                else if (nums[l] == minQueue.peekFirst()) minQueue.pollFirst();
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
