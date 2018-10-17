class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < nums.length * 2; i++) {
            int cur = nums[i % nums.length];
            while (!stack.isEmpty() && cur > nums[stack.peek()]) res[stack.pop()] = cur;
            //stack.push(i % nums.length);
            if (i < nums.length) stack.push(i);
        }
        return res;
    }
}
