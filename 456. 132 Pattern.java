class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length <= 2) return false;
        Stack<Integer> stack = new Stack<>();
        int s2 = Integer.MIN_VALUE; //third one
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < s2 && !stack.isEmpty()) return true; //找到一个小于s2的即成立
            while (!stack.isEmpty() && stack.peek() < nums[i]) s2 = stack.pop(); //既然有更大的 s2要更新
            stack.push(nums[i]); //大的放进去
        }
        return false;
    }
}
